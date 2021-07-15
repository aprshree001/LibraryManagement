package com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.modal.Book;
import com.library.modal.Borrow;

public interface BorrowRepo extends  JpaRepository<Borrow, String> {
	
	
	
	
	@Query(value = "SELECT count(b.borrowId) FROM Borrow b WHERE b.userId = :userId group by userId")
	Integer findNoOfBookByUserId(@Param("userId") String userId);
	
	

	
	@Query(value = "SELECT EXISTS(SELECT b from Browser b where b.userId = :userId and b.bookId = :bookId)")
	Integer findBookAlreadyAssignedOrNot(@Param("userId") String userId, @Param("bookId") String bookId);
	
	
	
	
}
