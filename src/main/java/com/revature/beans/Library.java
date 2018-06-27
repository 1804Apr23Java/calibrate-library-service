package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.revature.dto.LibraryDTO;

@Entity
@Table(name = "LIBRARY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Library {

	private int id;
	private String name;
	private Status status;
	private Integer accountId;
	private Integer numberOfQuestions;
	
	
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(int id, String name, Status status, Integer accountId, Integer numberOfQuestions) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.setNumberOfQuestions(numberOfQuestions);
	}

	public Library(String name, Status status, Integer accountId, Integer numberOfQuestions) {
		super();
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.setNumberOfQuestions(numberOfQuestions);
	}
	
	public Library(LibraryDTO library) {
		super();
		this.name = library.getName();
		this.status = library.getStatus();
		this.accountId = library.getAccountId();
		this.numberOfQuestions = library.getNumberOfQuestions();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "librarySequence")
	@SequenceGenerator(allocationSize = 1, name = "librarySequence", sequenceName = "SQ_LIBRARY_PK")
	@Column(name = "LIBRARY_ID", nullable =false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "STATUS", nullable = false)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "ACCOUNTID", nullable = false)
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@Column(name = "NUMBEROFQUESTION", nullable = false)
	public Integer getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(Integer numberOfQuestion) {
		this.numberOfQuestions = numberOfQuestion;
	}

}
