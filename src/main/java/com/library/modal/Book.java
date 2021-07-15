package com.library.modal;

import javax.persistence.*;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "Book")


public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private String bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String authorName;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "no_of_copies")
	private int num_of_copies;
	
	
	@ManyToOne
	@JoinColumn(name="libId")
	private Library lib;
	
	@ManyToOne
	@JoinColumn(name ="borrowId")
	private Borrow borrow;
	
	
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getNum_of_copies() {
		return num_of_copies;
	}
	public void setNum_of_copies(int num_of_copies) {
		this.num_of_copies = num_of_copies;
	}
	
	
	

}
