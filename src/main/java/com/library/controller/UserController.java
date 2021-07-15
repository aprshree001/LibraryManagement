package com.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.modal.Book;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;

@RestController
public class UserController {
	
	
	
	
	
	
	public ResponseEntity<HTTPResponse> addBook(@RequestBody Book book){
		
		String title = book.getTitle();
		String author = book.getAuthorName();
		String id = book.getBookId();
		String publisher = book.getPublisher();
		
		
		Book newbook = new Book();
		newbook.setBookId(id);
		newbook.setAuthorName(author);
		newbook.setTitle(title);
		newbook.setPublisher(publisher);
		
		
		
		
		
		return null;
		
		
		
		
	}
	
	
	
	
	
	

}
