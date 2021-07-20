package com.library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.modal.BookEntity;
import com.library.modal.BorrowEntity;

public interface BorrowRepo extends JpaRepository<BorrowEntity, String> {

	@Query(value = "SELECT b FROM BorrowEntity b WHERE b.userId = :userId")
	List<BorrowEntity> findBorrowByUserId(@Param("userId") String userId);

	@Query(value = "SELECT b FROM BorrowEntity b WHERE b.userId = :userId AND b.bookId = :bookId")
	Optional<BorrowEntity> findByUserIdAndBookId(@Param("userId") String userId, @Param("bookId") String bookId);

	@Modifying
	@Query(value = "DELETE FROM BorrowEntity b WHERE b.userId = :userId and b.bookId = :bookId")
	void removeBorrowBookFromUser(@Param("userId") String userId,@Param("bookId") String bookid);

}
