package com.revature.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.beans.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

	public Library findLibraryById(int id);
	
	public List<Library> findLibraryByStatus(int status);
	
	public Library findLibraryByAccountId(int accoundId);
	
	
	
}
