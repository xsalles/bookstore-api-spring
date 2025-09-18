package com.bookstore.main.modules.Books.handlers;

import com.bookstore.main.common.dto.ApiResponseDto;
import com.bookstore.main.modules.Books.exceptions.BookAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookAlreadyExistsHandler {

	public ResponseEntity<ApiResponseDto<String>> handleBookAlreadyExistsException(BookAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new ApiResponseDto<String>(ex.getMessage(), HttpStatus.CONFLICT.value()));
	}

}
