package com.library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.modal.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, String> {
	
	List<BookEntity> findByTitle(String title);
	List<BookEntity> findByAuthorName(String title);
	
}
