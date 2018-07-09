package com.revature.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.Set;

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
	public void addNewLibraryTest() {
		Library lib = new Library(3, "Hibernate", Status.PENDING, 1, 10);
		libraryService.addNewLibrary(lib);
		assertEquals(3, libraryService.getLibraryById(3).getId());
	}


	@Test
	public void getByIdTest() {
		Library lib = new Library("Hibernate", Status.PENDING, 1, 10);
		libraryService.addNewLibrary(lib);
		System.out.println(lib.getId());
		assertEquals(1, libraryService.getLibraryById(1).getId());
	}
	@Test
	public void deleteLibraryTest() {
	
		libraryService.addNewLibrary(new Library("New Library 4", Status.PRIVATE, 1000, 0));
		libraryService.addNewLibrary(new Library("New Library 5", Status.PUBLIC, 1000, 0));
		Library lib=libraryService.addNewLibrary(new Library("New Library 6", Status.PENDING, 1000, 0));
		libraryService.deleteLibraryById(lib.getId());
		Set<Library> libraries = libraryService.getLibrariesByAccountId(1000);
		
		
		for (Library libr : libraries) {
			System.out.println(libr.getId());
		}
		
		assertEquals(2, libraries.size());
	}

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
		Library library = libraryService.addNewLibrary(new Library("New Library", Status.PENDING, 34, 0));
		libraryService.getLibraryById(library.getId());
		assertEquals(Status.PENDING, library.getStatus());

	}

}
