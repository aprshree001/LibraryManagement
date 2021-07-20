package com.library.service;

import com.library.modal.BorrowEntity;

import dto.BorrowRequestDto;

public interface BorrowServiceInterface {

	public BorrowEntity addBookToBorrowItems(BorrowRequestDto userrequest);
	public void returnBookFromBorrowedItems(BorrowRequestDto userrequest);

}
