package com.library.service;

import com.library.modal.BookEntity;

public interface UserServiceInterface {
	
	
	public void addBookItem(BookEntity bookitem);
	public void getAllBookList();
	public void editBookItem();
	public void returnBookItem();
	
	

}


