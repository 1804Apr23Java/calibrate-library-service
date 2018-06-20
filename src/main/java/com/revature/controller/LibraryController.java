package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Library;
import com.revature.repository.LibraryRepository;

@RestController
public class LibraryController {

	@Autowired
	LibraryRepository libraryrepository;

	@GetMapping(path = "/findservice")
	public String helloWorld() {
		return "Hello from Library";
	}

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Library> getpublic(@PathVariable int id) {
		return new ResponseEntity<Library>(libraryrepository.getOne(id), HttpStatus.OK);
	}

	@GetMapping(path = "/pending/{pend}")
	public ResponseEntity<List<Library>> getPendingLibrary(@PathVariable String pend) {
		return new ResponseEntity<>(libraryrepository.findAll(), HttpStatus.OK);

	}

	@GetMapping("/byaccountId/{accountId}")
	public ResponseEntity<Library> getLibraryByAccountId(@PathVariable int accountId) {
		return new ResponseEntity<Library>(libraryrepository.getOne(accountId), HttpStatus.OK);
	}

	@PostMapping("/new/{libraryName}/accountId/{accountId}")
	public ResponseEntity<Library> createLibrary(@PathVariable String libraryName, int accoundId){
		return null;
	}

	// @GetMapping("/delete/{id}")

	// @GetMapping("/id/{id}/status/{status}")

}
