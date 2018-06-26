package com.revature.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Library;
import com.revature.beans.Status;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

	
	// Find Library by Id
	public Library findLibraryById(int id);

	// Find Library by the Status ( Private, Public, Pending )
	public List<Library> findLibrarysByStatus(Status status);
	
	//Find all libraries by account id
	public Set<Library> findByAccountId(Integer id);
	
	//public int deleteById(int id);
	

}
