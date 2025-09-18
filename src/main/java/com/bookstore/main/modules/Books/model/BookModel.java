package com.bookstore.main.modules.Books.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

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

	@ISBN(type = org.hibernate.validator.constraints.ISBN.Type.ANY, message = "Invalid ISBN format")
	private String ISBN;

	@Pattern(regexp = "^\\d{4}$\n")
	private Integer yearPublished;
}
