package com.revature.dto;

import java.util.Set;

import com.revature.beans.Library;

public class LibraryDTO {

	private int id;
	private String name;
	private String status;
	private Integer accountId;
	private Integer numberOfQuestion;

	public LibraryDTO() {
		super();
		
	}

	public LibraryDTO(int id, String name, String status, Integer accountId,Integer numberOfQuestion) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.numberOfQuestion = numberOfQuestion;
	}

	public LibraryDTO(String name, String status, Integer accountId, Integer numberOfQuestion) {
		super();
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.numberOfQuestion = numberOfQuestion;
	}
	
	public LibraryDTO (Library library) {
		super();
		this.id=library.getId();
		this.name=library.getName();
		this.status=library.getStatus();
		this.accountId=library.getAccountId();
		this.numberOfQuestion=library.getNumberOfQuestion();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(Integer numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}


	
	

	
}
