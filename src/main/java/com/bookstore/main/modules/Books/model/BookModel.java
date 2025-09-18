package com.bookstore.main.modules.Books.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Pattern(regexp = "^[\\p{L} .'-]+$", message = "Author name contains invalid characters")
	private String author;

	private String title;

	@Pattern(regexp = "^[\\p{L} .'-]+$", message = "Genre contains invalid characters")
	private String genre;

	@Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message = "Invalid ISBN format")
	private String ISBN;

	private Integer year;
}
