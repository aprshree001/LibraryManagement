package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.modal.Book;
import com.library.modal.Borrow;
import com.library.serviceImp.BorroServiceImpl;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;

import dto.UserRequestdto;

@RestController
public class BorrowListController {
	
	
	@Autowired
	BorroServiceImpl borrowService;
	
	

	@PostMapping("/addBook")
	public ResponseEntity<Borrow> addBook(@RequestBody UserRequestdto UserRequestdto){
		
	
		
	
		String  userid = UserRequestdto.getBookid();
		String  bookid = UserRequestdto.getBookid();
		Integer quantity = UserRequestdto.getQuantity();
		
		UserRequestdto userrequest = new UserRequestdto();
		
		userrequest.setBookid(bookid);
		userrequest.setUserid(userid);
		userrequest.setQuantity(quantity);
		
		Borrow response = borrowService.addBookToBorrowList(userrequest);
		
		
	     return new ResponseEntity<Borrow>(response, HttpStatus.OK);
		
		
		
	}
	
	

}
