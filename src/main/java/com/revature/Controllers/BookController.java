package com.revature.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Services.LibraryService;
import com.revature.models.Book;
import com.revature.models.LibraryUser;

@RestController
@RequestMapping(value = "book")
@CrossOrigin
public class BookController {

	private LibraryService libraryService;

	@Autowired
	public BookController(LibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}

	@GetMapping()
	public ResponseEntity<LibraryUser> getUser(HttpSession session) {
		if (session != null) {
			String username = (String) session.getAttribute("username");
			LibraryUser user = libraryService.getUserByUsername(username);
			return ResponseEntity.status(200).body(user);
		} else {
			System.out.println("Please login first");
			return null;
		}
	}

	@PostMapping()
	public ResponseEntity<LibraryUser> addBook(@RequestParam("bookID") int bookID, HttpSession session) {
		String username = (String) session.getAttribute("username");
		LibraryUser user = libraryService.getUserByUsername(username);
		Book book = new Book(bookID, user);
		libraryService.addBook(book);
		user = libraryService.getUserByUsername(username);
		return ResponseEntity.status(200).body(user);
	}

	@DeleteMapping()
	public ResponseEntity<LibraryUser> deleteBook(@RequestParam("bookID") int bookID, HttpSession session) {
		String username = (String) session.getAttribute("username");
		LibraryUser user = libraryService.getUserByUsername(username);
		Book book = new Book(bookID, user);
		libraryService.destroyBook(bookID);
		user = libraryService.getUserByUsername(username);
		return ResponseEntity.status(200).body(user);
	}

}
