package com.revature.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Repos.BooksDAO;
import com.revature.Repos.UserDAO;
import com.revature.models.Book;
import com.revature.models.User;

@Service
public class LibraryService {

	private BooksDAO booksDAO;
	private UserDAO usersDAO;

	@Autowired
	public LibraryService(BooksDAO booksDAO, UserDAO userDAO) {
		super();
		this.booksDAO = booksDAO;
		this.usersDAO = userDAO;
	}

	// addUser, findUser for login route, add book, delete book,

	public void registerUser(User newUser) {
		usersDAO.save(newUser);
	}

	public User loginUser(String username, String password) {
		Optional<User> optional = usersDAO.findByuserName(username);
		if (optional.isPresent()) {
			if (optional.get().getPassword().equals(password)) {

				return optional.get();
			}
		}
		return null;
	}

	public void addBook(Book book) {
		booksDAO.save(book);
	}

	public Book getBookByID(int id) {
		Optional<Book> optional = booksDAO.findById(id);
		return (optional.isPresent() ? optional.get() : null);
	}

	public void destroyBook(int id) {
		Book book = getBookByID(id);
		booksDAO.delete(book);
	}

}
