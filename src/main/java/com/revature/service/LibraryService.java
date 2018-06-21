package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Library;
import com.revature.repository.LibraryRepository;

@Service
public class LibraryService {
	@Autowired
	LibraryRepository libraryrepository;

	public Library getLibrariesById(int libraryId) {
		return libraryrepository.getOne(libraryId);
	}

	public List<Library> getLibraryStatusReport(String status) {
		
		List<Library> lib= libraryrepository.findAll();
		return lib;
				
	}
	
	public  List<Library> getLibraryPend(int pend) {		
		List<Library> lib = libraryrepository.findLibraryByStatus(pend);
		return lib;
	}
	

	public List<Library> getLibrariesByAccountID(int accountId) {
		return libraryrepository.findAll();
	}

	public Library addNewLibrary(Library Lib) {
		return Lib;
	}
}
