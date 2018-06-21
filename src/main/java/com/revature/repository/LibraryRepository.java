package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Library;
import com.revature.beans.Status;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

	public Library findLibraryById(int id);

	public List<Library> findLibraryByStatus(Status status);

	@Query(value = "SELECT * FROM LIBRARY WHERE STATUS = ?1", nativeQuery = true)
	public List<Library> pendLibrary(String status);
	
	public Library findLibraryByAccountId(int accoundId);

}
