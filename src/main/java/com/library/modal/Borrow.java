package com.library.modal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "BORROW_DETAILS")
public class Borrow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String borrowId;
	
	
	@Column(name = "NO_OF_BOOK")
	private Integer no_of_book;
	
	@Column(name="USER_ID")
	private String userId;
	
	@ManyToOne
    @JoinColumn(name="USER_ID",referencedColumnName = "USER_ID",updatable = false,insertable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name="BOOK_ID",referencedColumnName = "BOOK_ID",updatable = false,insertable = false)
	private Book book;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	@Column(name="BOOK_ID")
	private String bookId;


	public String getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getNo_of_book() {
		return no_of_book;
	}
	public void setNo_of_book(Integer no_of_book) {
		this.no_of_book = no_of_book;
	}
	

}
