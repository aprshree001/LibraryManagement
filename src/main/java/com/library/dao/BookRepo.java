package com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.modal.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	
	
	List<Book> findBybookId(Integer id);
	List<Book> findBytitle(String title);
	List<Book> findByauthor(String title);
	

}
