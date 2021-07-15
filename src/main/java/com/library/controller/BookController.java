package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dao.BookRepo;
import com.library.modal.Book;

@RestController

@RequestMapping("/api")
public class BookController {

	@Autowired
	BookRepo bookRepository;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBookList() {

		List<Book> booklist = new ArrayList<Book>();
		bookRepository.findAll().forEach(booklist::add);
		if (booklist.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(booklist, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") Integer id) {
		try {
			Book response = bookRepository.getById(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {

		Book addbook = new Book();

		addbook.setTitle(book.getTitle());
		addbook.setAuthorName(book.getAuthorName());
		bookRepository.save(addbook);

		return new ResponseEntity<Book>(addbook, HttpStatus.CREATED);

	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("bookId") Integer id) {
		try {
			bookRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	}
	

