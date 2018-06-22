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

	public List<Library> getLibraryStatus(String status) {
		List<Library> lib = libraryrepository.findLibraryByStatus(status);
		return lib;
	}

	public List<Library> getLibrariesByAccountID(int accountId) {
		List<Library> lib = libraryrepository.findAll();
		return lib;
	}

	public Library addNewLibrary(Library library) {
		return libraryrepository.save(library);
	}

	public boolean deleteLibraryById(int id) {			
		return libraryrepository.deleteLibraryById(id);
				
	}

}
