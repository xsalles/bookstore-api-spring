package com.bookstore.main.modules.Books.handlers;

import com.bookstore.main.common.dto.ApiResponseDto;
import com.bookstore.main.modules.Books.exceptions.BookUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookUnavailableHandler {
	public ResponseEntity<ApiResponseDto<String>> handleBookUnavailableException(BookUnavailableException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new ApiResponseDto<String>(ex.getMessage(), HttpStatus.CONFLICT.value()));
	}
}
