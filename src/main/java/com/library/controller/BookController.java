package com.library.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dao.BookRepo;
import com.library.dao.LibraryReo;
import com.library.exception.LibraryEntityNotFoundException;
import com.library.modal.BookEntity;
import com.library.modal.Library;
import com.library.service.BookServiceInterface;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookRepo bookRepository;
	
	@Autowired
	LibraryReo libraryrepo;

	@Autowired
	BookServiceInterface bookService;

	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getAllBookList() {

		List<BookEntity> booklist = new ArrayList<BookEntity>();
		bookRepository.findAll().forEach(booklist::add);
		if (booklist.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(booklist, HttpStatus.OK);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookEntity> getBookById(@PathVariable("id") String id) {
		
			Optional<BookEntity> response = bookRepository.findById(id);
			if(response.isPresent())
			return new ResponseEntity<>(response.get(), HttpStatus.OK);
			
			return new ResponseEntity<BookEntity>(HttpStatus.NOT_FOUND);
		
	}

	@PostMapping("/books")
	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity book) {

		Optional<Library> library = libraryrepo.findById(book.getLibId());
		if(!library.isPresent()) {
			
			throw new LibraryEntityNotFoundException("Library id is wrong it doesnot exist");
		}
		BookEntity response = bookRepository.save(book);

		return new ResponseEntity<BookEntity>(response, HttpStatus.CREATED);

	}

}
