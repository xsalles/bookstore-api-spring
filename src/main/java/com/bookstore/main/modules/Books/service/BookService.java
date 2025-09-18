package com.bookstore.main.modules.Books.service;

import com.bookstore.main.common.dto.ApiResponseDto;
import com.bookstore.main.modules.Books.exceptions.BookAlreadyExistsException;
import com.bookstore.main.modules.Books.model.BookModel;
import com.bookstore.main.modules.Books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public ResponseEntity<ApiResponseDto<BookModel>> createBook(BookModel bookModel) {
        if (bookRepository.existsByIsbn(bookModel.getIsbn())) {
			throw new BookAlreadyExistsException("Book already exists.");
        }

		bookRepository.save(bookModel);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponseDto<BookModel>("Book created successfully.", HttpStatus.CREATED.value(), bookModel));
	}
}
