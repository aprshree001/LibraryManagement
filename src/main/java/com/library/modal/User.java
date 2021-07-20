package com.library.modal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "FIRST_NAME")
	private String FirstName;

	@Column(name = "LAST_NAME")
	private String LastName;

	@Column(name = "EMAIL")
	private String email;

	@OneToMany(mappedBy = "user")
	private List<BorrowEntity> borrowlist;

}
