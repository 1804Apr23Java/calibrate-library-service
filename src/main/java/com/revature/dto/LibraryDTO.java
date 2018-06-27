package com.revature.dto;



import com.revature.beans.Library;
import com.revature.beans.Status;

public class LibraryDTO {

	private int libraryId;
	private String name;
	private Status status;
	private Integer accountId;
	private Integer numberOfQuestions;
	
	

	public LibraryDTO() {
		super();
		
	}

	public LibraryDTO(int id, String name, Status status, Integer accountId,Integer numberOfQuestions) {
		super();
		this.libraryId = id;
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.numberOfQuestions = numberOfQuestions;
	}

	public LibraryDTO(String name, Status status, Integer accountId, Integer numberOfQuestions) {
		super();
		this.name = name;
		this.status = status;
		this.accountId = accountId;
		this.numberOfQuestions = numberOfQuestions;
	}
	
	public LibraryDTO (Library library) {
		super();
		this.libraryId=library.getId();
		this.name=library.getName();
		this.status=library.getStatus();
		this.accountId=library.getAccountId();
		this.numberOfQuestions=library.getNumberOfQuestions();
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
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

	public Integer getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(Integer numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	
	
}
