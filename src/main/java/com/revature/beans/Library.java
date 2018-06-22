package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class Library {

	private int id;
	private String name;
	private String status;
	private Integer accountId;
	private Integer numberOfQuestion;

	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(int id, String name, String status, Integer accountId, Integer numberOfQuestion) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.setNumberOfQuestion(numberOfQuestion);
	}

	public Library(String name, String status, Integer accountId, Integer numberOfQuestion) {
		super();
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.setNumberOfQuestion(numberOfQuestion);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "librarySequence")
	@SequenceGenerator(allocationSize = 1, name = "librarySequence", sequenceName = "SQ_LIBRARY_PK")
	@Column(name = "LIBRARY_ID")
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
	public Integer getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(Integer numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

}
