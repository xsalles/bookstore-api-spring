package com.bookstore.main.modules.Books.service;

import com.bookstore.main.common.dto.ApiResponseDto;
import com.bookstore.main.modules.Books.exceptions.BookAlreadyExistsException;
import com.bookstore.main.modules.Books.exceptions.BookNotFoundException;
import com.bookstore.main.modules.Books.model.BookModel;
import com.bookstore.main.modules.Books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

	public ResponseEntity<ApiResponseDto<List<BookModel>>> getAllBooks() {
		if (bookRepository.findAll().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponseDto<>("Books retrived sucessfully.", HttpStatus.OK.value(), bookRepository.findAll()));
	}

	public ResponseEntity<ApiResponseDto<BookModel>> getBookById(Integer id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new BookNotFoundException("Book not found.");
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponseDto<BookModel>("Book retrived sucessfully.", HttpStatus.OK.value(), bookRepository.findById(id).get()));
	}
}
