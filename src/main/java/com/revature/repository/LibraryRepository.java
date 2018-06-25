package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Library;
import com.revature.beans.Status;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

	// Find Library by Id
	public Library findLibraryById(int id);

	// Find Library by the Status ( Private, Public, Pending )
	public List<Library> findLibraryByStatus(String status);

	// Find Library by the Account_ID
	public Library findLibraryByAccountId(Integer accountId);
	
	//Delete Library by Library_ID	
	public void deleteLibraryById(Integer id);
	
	

}
