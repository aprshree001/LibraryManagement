package com.library.modal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private String bookId;

	@Column(name = "title")
	private String title;

	@Column(name = "AUTHOR_NAME")
	private String authorName;

	@Column(name = "publisher")
	private String publisher;

	@Column(name = "no_of_copies")
	private int noOfCopies;

	@Column(name = "LIBRARY_ID")
	private int libId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "LIBRARY_ID", referencedColumnName = "LIBRARY_ID", updatable = false, insertable = false)
	private Library lib;


}
