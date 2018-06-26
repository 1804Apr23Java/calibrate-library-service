package com.revature.dto;



import com.revature.beans.Library;
import com.revature.beans.Status;

public class LibraryDTO {

	private int id;
	private String name;
	private Status status;
	private Integer accountId;
	private Integer numberOfQuestion;
	
	

	public LibraryDTO() {
		super();
		
	}

	public LibraryDTO(int id, String name, Status status, Integer accountId,Integer numberOfQuestion) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.numberOfQuestion = numberOfQuestion;
	}

	public LibraryDTO(String name, Status status, Integer accountId, Integer numberOfQuestion) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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
