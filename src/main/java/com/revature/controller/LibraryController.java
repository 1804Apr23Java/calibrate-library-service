package com.revature.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Library;
import com.revature.beans.Status;
import com.revature.dto.LibraryDTO;
import com.revature.service.LibraryService;

@CrossOrigin
@RestController
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	// Testing to find the name of the service
	@GetMapping(path = "/findservice")
	public String helloWorld() {
		return "Hello from Library";
	}

	// Get Library By library Id
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<LibraryDTO> getpublic(@PathVariable int id) {
		Library library = libraryService.getLibraryById(id);
		return new ResponseEntity<LibraryDTO>(new LibraryDTO(library), HttpStatus.OK);
	}

	@GetMapping(path = "/status/pending")
	public ResponseEntity<List<LibraryDTO>> getPendingLibraries() {
		List<Library> libraries = libraryService.getLibraryByStatus(Status.PENDING);
		return new ResponseEntity<>(libraries.stream().map(LibraryDTO::new).collect(Collectors.toList()),
				HttpStatus.OK);

	}

	@GetMapping(path = "/status/private")
	public ResponseEntity<List<LibraryDTO>> getPrivateLibraries() {
		List<Library> libraries = libraryService.getLibraryByStatus(Status.PRIVATE);
		return new ResponseEntity<>(libraries.stream().map(LibraryDTO::new).collect(Collectors.toList()),
				HttpStatus.OK);

	}

	@GetMapping(path = "/status/public")
	public ResponseEntity<List<LibraryDTO>> getPublicLibraries() {
		List<Library> libraries = libraryService.getLibraryByStatus(Status.PUBLIC);
		return new ResponseEntity<>(libraries.stream().map(LibraryDTO::new).collect(Collectors.toList()),
				HttpStatus.OK);

	}

	// Get the list of Library by the accountId
	@GetMapping("/byAccountId/{accountId}")
	public ResponseEntity<List<LibraryDTO>> getLibrariesByAccountId(@PathVariable int accountId) {
		Set<Library> libraries = libraryService.getLibrariesByAccountId(accountId);
		return new ResponseEntity<>(libraries.stream().map(LibraryDTO::new).collect(Collectors.toList()),
				HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<LibraryDTO> createLibrary(@RequestBody LibraryDTO newLibrary) {
		Library addedLibrary = libraryService.addNewLibrary(new Library(newLibrary));
		return new ResponseEntity<>(new LibraryDTO(addedLibrary), HttpStatus.OK);
	}

	@PostMapping("/delete/{id}")
	public void deleteLibrary(@PathVariable int id) {
		System.out.println(id);
		libraryService.deleteLibraryById(id);

	}

	@PatchMapping("/makePrivate")
	public ResponseEntity<LibraryDTO> makeLibraryPrivate(@RequestBody Integer libraryId) {
		return new ResponseEntity<LibraryDTO>(new LibraryDTO(libraryService.updateLibrary(libraryId, Status.PRIVATE)),
				HttpStatus.OK);
	}

	@PatchMapping("/makePublic")
	public ResponseEntity<LibraryDTO> makeLibraryPublic(@RequestBody Integer libraryId) {
		return new ResponseEntity<LibraryDTO>(new LibraryDTO(libraryService.updateLibrary(libraryId, Status.PUBLIC)),
				HttpStatus.OK);
	}

	@PatchMapping("/makePending")
	public ResponseEntity<LibraryDTO> makeLibraryPending(@RequestBody Integer libraryId) {
		return new ResponseEntity<LibraryDTO>(new LibraryDTO(libraryService.updateLibrary(libraryId, Status.PENDING)),
				HttpStatus.OK);
	}

}
