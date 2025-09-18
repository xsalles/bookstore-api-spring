package com.bookstore.main.modules.Books.controller;

import com.bookstore.main.common.dto.ApiResponseDto;
import com.bookstore.main.modules.Books.model.BookModel;
import com.bookstore.main.modules.Books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponseDto<BookModel>> createBook(@RequestBody BookModel bookModel) {
		return bookService.createBook(bookModel);
	}
}
