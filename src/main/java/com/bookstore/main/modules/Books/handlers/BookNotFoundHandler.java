package com.bookstore.main.modules.Books.handlers;

import com.bookstore.main.common.dto.ApiResponseDto;
import com.bookstore.main.modules.Books.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookNotFoundHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ApiResponseDto<String>> handleBookNotFoundException(BookNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponseDto<String>(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
	}
}
