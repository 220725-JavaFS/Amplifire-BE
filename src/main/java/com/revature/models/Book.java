package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@Column
	private int gutendex_book_id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	public Book() {
		super();
	}

	public int getGutendex_book_id() {
		return gutendex_book_id;
	}

	public void setGutendex_book_id(int gutendex_book_id) {
		this.gutendex_book_id = gutendex_book_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gutendex_book_id, user);
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
		return gutendex_book_id == other.gutendex_book_id && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Book [gutendex_book_id=" + gutendex_book_id + ", user=" + user + "]";
	}

}
