package com.revature.servicetest;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Library;
import com.revature.service.LibraryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LibraryServiceTest {
	
	

	@Autowired
	LibraryService libraryservice;
	
	
	@Test
	public void getbyidtest() {
		assertEquals(1,libraryservice.getLibrariesById(1).getId());
	}
	
	@Test
	public void addNewLibraryTest() {
		
		Library lib = new Library("Hibernate", "pending", 1 ,20);	
		libraryservice.addNewLibrary(lib);
		assertEquals(3, libraryservice.getLibrariesById(3).getId());
		
	}
	
	@Test
	public void getLibrariesByAccountIDTest() {
		List<Library> lib=libraryservice.getLibrariesByAccountID(1);		
		assertEquals(2,lib.size());
	}
	
}
