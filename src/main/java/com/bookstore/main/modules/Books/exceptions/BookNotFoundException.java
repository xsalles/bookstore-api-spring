package com.bookstore.main.modules.Books.exceptions;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(String message) {
		super(message);
	}
}
