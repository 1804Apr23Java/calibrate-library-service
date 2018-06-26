package com.revature.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.revature.beans.Library;
import com.revature.beans.Status;
import com.revature.beans.StatusConverter;
import com.revature.dto.LibraryDTO;
import com.revature.repository.LibraryRepository;

@Service
@Transactional
public class LibraryService {


	
	@Autowired
	LibraryRepository libraryrepository;

	public Library getLibrariesById(int libraryId) {
		if (libraryId == 0) {
			System.out.println("Invalid LibraryId");
			return null;
		} else {
			return libraryrepository.getOne(libraryId);

		}
	}

	public List<Library> getLibraryStatus(Status status) {
		List<Library> lib = libraryrepository.findLibraryByStatus(Status.PENDING);
		return lib;
	}

	public List<Library> getLibrariesByAccountID(int accountId) {
		List<Library> lib = libraryrepository.findAll();
		return lib;
	}

	public Library addNewLibrary(Library library) {
		return libraryrepository.save(library);
	}

	public Library updateLibrary(int id, Status status) {
		Library lib = libraryrepository.getOne(id);
		lib.setStatus(status);
		return libraryrepository.save(lib);
	}

	public void deleteLibraryById(int id) {
		libraryrepository.deleteLibraryById(id);			
	}

}
