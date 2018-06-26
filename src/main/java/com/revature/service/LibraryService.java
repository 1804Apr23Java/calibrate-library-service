package com.revature.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Library;
import com.revature.beans.Status;
import com.revature.repository.LibraryRepository;

@Service
@Transactional
public class LibraryService {

	@Autowired
	LibraryRepository libraryRepository;

	public Library getLibraryById(int libraryId) {
		return libraryRepository.getOne(libraryId);
	}

	public List<Library> getLibraryByStatus(Status status) {
		List<Library> lib = libraryRepository.findLibrarysByStatus(status);
		return lib;
	}

	public Set<Library> getLibrariesByAccountId(int accountId) {
		Set<Library> lib = libraryRepository.findByAccountId(accountId);
		return lib;
	}

	public Library addNewLibrary(Library library) {
		return libraryRepository.save(library);
	}

	public Library updateLibrary(int id, Status status) {
		Library lib = libraryRepository.getOne(id);
		lib.setStatus(status);
		return libraryRepository.save(lib);
	}

	public void deleteLibraryById(int id) {
		libraryRepository.delete(id);
	}

}
