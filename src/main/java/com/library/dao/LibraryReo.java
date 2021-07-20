package com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.Param;

import com.library.modal.BookEntity;
import com.library.modal.Library;

public interface LibraryReo extends JpaRepository<Library, Integer> {

	@Query("SELECT l FROM Library l inner join BookEntity b on b.libId = l.libId  where l.libId = :libId")
	List<BookEntity> findAllBookByLibId(@Param("libId") Integer libId);

}
