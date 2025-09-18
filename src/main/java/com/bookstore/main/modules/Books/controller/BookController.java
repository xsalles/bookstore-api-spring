package com.bookstore.main.modules.Books.controller;

import com.bookstore.main.common.dto.ApiResponseDto;
import com.bookstore.main.modules.Books.model.BookModel;
import com.bookstore.main.modules.Books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponseDto<BookModel>> createBook(@RequestBody BookModel bookModel) {
		return bookService.createBook(bookModel);
	}

	@GetMapping("")
	public ResponseEntity<ApiResponseDto<List<BookModel>>> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseDto<BookModel>> getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponseDto<BookModel>> updateBook(@PathVariable Integer id, @RequestBody BookModel bookModel) {
		return bookService.updateBook(id, bookModel);
	}


}
