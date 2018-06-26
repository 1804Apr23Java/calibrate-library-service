package com.revature.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Library;
import com.revature.beans.Status;
import com.revature.service.LibraryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LibraryServiceTest {

	@Autowired
	LibraryService libraryService;

	@Test
	public void getByIdTest() {
		assertEquals(1, libraryService.getLibraryById(1).getId());
	}

	@Test
	public void addNewLibraryTest() {
		Library lib = new Library(3, "Hibernate", Status.PENDING, 1, 10);
		libraryService.addNewLibrary(lib);
		assertEquals(3, libraryService.getLibraryById(3).getId());
	}
//
//	@Test(expected=EntityNotFoundException.class)
//	public void deleteLibraryTest() {
//		Library library = libraryService.addNewLibrary(new Library ("Newest Library", Status.PRIVATE, 45, 0));
//		libraryService.deleteLibraryById(library.getId());
//		System.out.println(libraryService.getLibraryById(library.getId()));
//
//	}

	@Test
	public void getLibrariesByAccountIdTest() {
		libraryService.addNewLibrary(new Library("New Library 1", Status.PRIVATE, 12, 0));
		libraryService.addNewLibrary(new Library("New Library 2", Status.PUBLIC, 12, 0));
		libraryService.addNewLibrary(new Library("New Library 3", Status.PENDING, 12, 0));
		Set<Library> libraries = libraryService.getLibrariesByAccountId(12);
		assertEquals(3, libraries.size());
	}

	@Test
	public void updateLibraryTest() {
		//String status = "PENDING";
		// Get library and then get the status
		Library library = libraryService.addNewLibrary(new Library("New Library", Status.PENDING, 34, 0));
		libraryService.getLibraryById(library.getId());
		assertEquals(Status.PENDING, library.getStatus());

	}

}
