package com.bookstore.main.modules.Books.model;

import com.bookstore.main.common.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

@Data
@Entity(name = "books")
public class BookModel {
	@Id
	@SequenceGenerator(name = "books_seq", sequenceName = "books_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_seq")
	private Integer id;

	@Pattern(regexp = "^[\\p{L} .'-]+$", message = "Author name contains invalid characters")
	@NotBlank(message = "Author cannot be blank")
	private String author;

	@NotBlank(message = "Title cannot be blank")
	private String title;

	@Pattern(regexp = "^[\\p{L} .'-]+$", message = "Genre contains invalid characters")
	@NotBlank(message = "Genre cannot be blank")
	private String genre;

	@ISBN(type = org.hibernate.validator.constraints.ISBN.Type.ANY, message = "Invalid ISBN format")
	@NotBlank(message = "ISBN cannot be blank")
	private String isbn;

	@NotNull(message = "Year published cannot be null")
	@Column(name = "year_published")
	private Integer yearPublished;

	private Status status = Status.AVAILABLE;
}
