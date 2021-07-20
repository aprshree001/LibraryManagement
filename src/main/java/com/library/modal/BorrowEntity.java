package com.library.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "BORROW")
public class BorrowEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String borrowId;

	@Column(name = "NO_OF_BOOK")
	private Integer noOfBook;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "BOOK_ID")
	private String bookId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", updatable = false, insertable = false)
	private User user;

	@OneToOne
	@JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID", updatable = false, insertable = false)
	private BookEntity book;

}
