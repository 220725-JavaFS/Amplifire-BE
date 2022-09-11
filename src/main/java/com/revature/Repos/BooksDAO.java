package com.revature.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Book;

public interface BooksDAO extends JpaRepository<Book, Integer> {

}
