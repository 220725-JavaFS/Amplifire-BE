package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Book {
	// get user JSONBackReference
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int book_id;

	@Column
	private String gutendex_book_id;

	@ManyToOne(fetch = FetchType.LAZY)
	private LibraryUser libraryUser;

	public Book() {
		super();
	}

	public Book(String gutendex_book_id, LibraryUser libraryUser) {
		super();
		this.gutendex_book_id = gutendex_book_id;
		this.libraryUser = libraryUser;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getGutendex_book_id() {
		return gutendex_book_id;
	}

	public void setGutendex_book_id(String gutendex_book_id) {
		this.gutendex_book_id = gutendex_book_id;
	}

	@JsonBackReference
	public LibraryUser getLibraryUser() {
		return libraryUser;
	}

	public void setLibraryUser(LibraryUser libraryUser) {
		this.libraryUser = libraryUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book_id, gutendex_book_id, libraryUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return book_id == other.book_id && gutendex_book_id == other.gutendex_book_id
				&& Objects.equals(libraryUser, other.libraryUser);
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", gutendex_book_id=" + gutendex_book_id + ", libraryUser=" + libraryUser
				+ "]";
	}

}
