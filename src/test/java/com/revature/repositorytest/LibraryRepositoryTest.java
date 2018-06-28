package com.revature.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.repository.LibraryRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class LibraryRepositoryTest {

	@Autowired
	 private LibraryRepository libraryRepository;

	@Test
	public void testFindAll() {		
	
		
//		Library library=new Library("New Library 1", Status.PRIVATE, 12, 0);
//		
//				
//		assertEquals(1, library.getAccountId());
		
/*		List<Library> library = libraryRepository.findAll();
		assertEquals(3, library.size()); */
	}

}
