package com.revature.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Library;
import com.revature.beans.Status;
import com.revature.service.LibraryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LibraryServiceTest {
	
	@Autowired
	Status status;

	@Autowired
	LibraryService libraryservice;
	
	
	@Test
	public void getbyidtest() {
		assertEquals(1,libraryservice.getLibrariesById(1).getId());
	}
	
	@Test
	public void addNewLibraryTest() {
		
		Library lib = new Library("Hibernate", Status.PENDING, 1 ,20);	
		libraryservice.addNewLibrary(lib);
		assertEquals(3, libraryservice.getLibrariesById(3).getId());
		
	}
	
	@Test(expected = JpaObjectRetrievalFailureException.class)
	@Transactional	
	public void deleteLibraryTest() {
		libraryservice.deleteLibraryById(3);		
		Library lib = libraryservice.getLibrariesById(3);		
		
	}
	
	
	@Test
	public void getLibrariesByAccountIDTest() {
		List<Library> lib=libraryservice.getLibrariesByAccountID(1);		
		assertEquals(3,lib.size());
	}
	
	@Test
	@Transactional 
	public void updateLibraryTest() {
		String status = "pending";
		int id = 2;
		//Get library and then get the status
		Library lib = libraryservice.updateLibrary(id, Status.PENDING);
		Library lib1 = libraryservice.getLibrariesById(2);	
		System.out.println("Test");
		assertEquals(status,lib.getStatus());
		
	}
	

	
}
