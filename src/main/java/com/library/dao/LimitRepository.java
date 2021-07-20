package com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.modal.BookEntity;
import com.library.modal.BorrowEntity;
import com.library.modal.Limit;

public interface LimitRepository extends JpaRepository<Limit, String> {

	Limit findByLimitName(@Param("limitName") String limitName);

}
