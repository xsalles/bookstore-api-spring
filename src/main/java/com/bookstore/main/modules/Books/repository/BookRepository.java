package com.bookstore.main.modules.Books.repository;

import com.bookstore.main.modules.Books.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Integer> {
	boolean existsByISBN(String isbn);
}
