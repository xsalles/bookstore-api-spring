package com.bookstore.main.modules.Books.exceptions;

public class BookUnavailableException extends RuntimeException {
	public BookUnavailableException(String message) {
		super(message);
	}
}
