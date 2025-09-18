package com.bookstore.main.modules.Books.service;

import com.bookstore.main.common.dto.ApiResponseDto;
import com.bookstore.main.common.enums.Status;
import com.bookstore.main.modules.Books.exceptions.BookAlreadyExistsException;
import com.bookstore.main.modules.Books.exceptions.BookNotFoundException;
import com.bookstore.main.modules.Books.exceptions.BookUnavailableException;
import com.bookstore.main.modules.Books.model.BookModel;
import com.bookstore.main.modules.Books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public ResponseEntity<ApiResponseDto<BookModel>> createBook(BookModel bookModel) {
		if (bookRepository.existsByIsbn(bookModel.getIsbn())) {
			throw new BookAlreadyExistsException("Book already exists.");
		}

		bookRepository.save(bookModel);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponseDto<BookModel>("Book created successfully.", HttpStatus.CREATED.value(), bookModel));
	}


	public ResponseEntity<ApiResponseDto<List<BookModel>>> getAllBooks() {
		if (bookRepository.findAll().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponseDto<>("Books retrived sucessfully.", HttpStatus.OK.value(), bookRepository.findAll()));
	}


	public ResponseEntity<ApiResponseDto<BookModel>> getBookById(Integer id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new BookNotFoundException("Book not found.");
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponseDto<BookModel>("Book retrived sucessfully.", HttpStatus.OK.value(), bookRepository.findById(id).get()));
	}


	public ResponseEntity<ApiResponseDto<BookModel>> updateBook(Integer id, BookModel bookModel) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new BookNotFoundException("This book doesn't exists.");
		}

		BookModel existingBook = bookRepository.findById(id).get();

		boolean alreadyExists = bookRepository.existsByIsbn(bookModel.getIsbn())
				&& !existingBook.getIsbn().equals(bookModel.getIsbn());

		if (alreadyExists) {
			throw new BookAlreadyExistsException("Book with this informations already exists.");
		}

		existingBook.setAuthor(bookModel.getAuthor());
		existingBook.setTitle(bookModel.getTitle());
		existingBook.setIsbn(bookModel.getIsbn());
		existingBook.setGenre(bookModel.getGenre());
		existingBook.setYearPublished(bookModel.getYearPublished());

		bookRepository.save(existingBook);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponseDto<BookModel>("Book updated sucessfully.", HttpStatus.OK.value(), bookRepository.findById(id).get()));
	}


	public ResponseEntity<ApiResponseDto<String>> deleteBook(Integer id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new BookNotFoundException("This book doesn't exists.");
		}

		bookRepository.deleteById(id);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponseDto<String>("Book deleted sucessfully.", HttpStatus.OK.value()));
	}


	public ResponseEntity<ApiResponseDto<String>> makeLoan(Integer id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new BookNotFoundException("This book doesn't exists.");
		}

		BookModel existingBook = bookRepository.findById(id).get();

		if (existingBook.getStatus().equals(Status.UNAVAILABLE)) {
			throw new BookUnavailableException("This book is currently unavailable.");
		}

		existingBook.setStatus(Status.UNAVAILABLE);

		bookRepository.save(existingBook);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponseDto<String>("Book lent sucessfully.", HttpStatus.OK.value()));
	}


	public ResponseEntity<ApiResponseDto<String>> returnBook(Integer id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new BookNotFoundException("This book doesn't exists.");
		}

		BookModel existingBook = bookRepository.findById(id).get();

		if (existingBook.getStatus().equals(Status.AVAILABLE)) {
			throw new BookUnavailableException("This book isn't currently on loan.");
		}

		existingBook.setStatus(Status.AVAILABLE);

		bookRepository.save(existingBook);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponseDto<String>("Book returned sucessfully.", HttpStatus.OK.value()));
	}
}
