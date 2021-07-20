package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.modal.BorrowEntity;
import com.library.service.BorrowServiceInterface;

import dto.BorrowRequestDto;

@RestController

public class BorrowListController {

	@Autowired
	BorrowServiceInterface borrowService;

	@PostMapping("/api/borrow")
	public ResponseEntity<BorrowEntity> addBook(@RequestBody BorrowRequestDto borrowRequest) {

		BorrowEntity response = borrowService.addBookToBorrowItems(borrowRequest);

		return new ResponseEntity<BorrowEntity>(response, HttpStatus.OK);

	}

	@PostMapping("/api/borrow/returnbook")
	public ResponseEntity returnBook(@RequestBody BorrowRequestDto bookrequest) {
		borrowService.returnBookFromBorrowedItems(bookrequest);
		return new ResponseEntity(HttpStatus.OK);
	}

}
