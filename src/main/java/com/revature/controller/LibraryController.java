package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.revature.beans.Library;
import com.revature.service.LibraryService;

@RestController
public class LibraryController {

	

	@Autowired
	LibraryService libraryservice;

	// Testing to find the name of the service
	@GetMapping(path = "/findservice")
	public String helloWorld() {
		return "Hello from Library";
	}

	// Get Library By library Id
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Library> getpublic(@PathVariable int id) {
		return new ResponseEntity<Library>(libraryservice.getLibrariesById(id), HttpStatus.OK);
	}

	
	
	@GetMapping(path = "/status/{status}")
	public ResponseEntity<List<Library>> getReportLibrary(@PathVariable String status) {
		return new ResponseEntity<>(libraryservice.getLibraryStatus(status), HttpStatus.OK);

	}
		
		
	// Get the list of Library by the accountId
	@GetMapping("/byaccountId/{accountId}")
	public ResponseEntity<List<Library>> getLibraryByAccountId(@PathVariable int accountId) {
		return new ResponseEntity<>(libraryservice.getLibrariesByAccountID(accountId),HttpStatus.OK);
	}

	
	@PostMapping("/new")
	public ResponseEntity<Library> createLibrary(@RequestBody Library library) {		
		return new ResponseEntity<>(libraryservice.addNewLibrary(library),HttpStatus.OK);	
		}

	@PostMapping("/delete/{id}")
	public  void deleteLibrary(@PathVariable int id){
		System.out.println(id);
		libraryservice.deleteLibraryById(id);
		
	}

	@PostMapping ("/id/{id}/status/{status}")
	public ResponseEntity<Library> updateLibrarybyId(@PathVariable int id, @PathVariable String status){
		return new ResponseEntity<> (libraryservice.updateLibrary(id, status),HttpStatus.OK);		
	}
	
}
