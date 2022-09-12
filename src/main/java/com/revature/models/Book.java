package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Book {

	@Id
	@Column(unique = true)
	private int gutendex_book_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private LibraryUser libraryUser;

	public Book() {
		super();
	}

	public int getGutendex_book_id() {
		return gutendex_book_id;
	}

	public void setGutendex_book_id(int gutendex_book_id) {
		this.gutendex_book_id = gutendex_book_id;
	}

	public Book(int gutendex_book_id, LibraryUser libraryUser) {
		super();
		this.gutendex_book_id = gutendex_book_id;
		this.libraryUser = libraryUser;
	}

	public LibraryUser getUser() {
		return libraryUser;
	}

	public void setUser(LibraryUser libraryUser) {
		this.libraryUser = libraryUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gutendex_book_id, libraryUser);
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
		return gutendex_book_id == other.gutendex_book_id && Objects.equals(libraryUser, other.libraryUser);
	}

	@Override
	public String toString() {
		return "Book [gutendex_book_id=" + gutendex_book_id + ", libraryUser=" + libraryUser + "]";
	}

}
