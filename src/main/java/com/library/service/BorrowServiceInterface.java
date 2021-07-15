package com.library.service;

import com.library.modal.Borrow;

import dto.UserRequestdto;

public interface BorrowServiceInterface {
	
	public Borrow addBookToBorrowList(UserRequestdto userrequest);
	
	public Integer findNoOfBookByUserId(String userId);
	
	public Integer findBookAlreadyAssignedOrNot(String userId, String bookId);
	

}
