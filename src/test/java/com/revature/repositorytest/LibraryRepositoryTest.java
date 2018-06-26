package com.revature.repositorytest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.revature.beans.Library;
import com.revature.repository.LibraryRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class LibraryRepositoryTest {

	@Autowired
	 private LibraryRepository libraryRepository;

	@Test
	public void testFindAll() {
//	List<Library> library = libraryRepository.findAll();
//	assertEquals(3, library.size());
	}

}
