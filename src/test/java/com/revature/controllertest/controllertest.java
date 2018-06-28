package com.revature.controllertest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.revature.beans.Library;
import com.revature.beans.Status;
import com.revature.service.LibraryService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class controllertest {

	@Autowired
	LibraryService libraryService;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = 8766;

	}

	@Test
	public void addLibrariesTest() throws JsonParseException, JsonMappingException, IOException {

		 RestAssured.port = 8766;
		 RequestSpecification request = RestAssured.given();
		 Library lib = libraryService.addNewLibrary(new Library("New Library 4",
		 Status.PRIVATE, 1000, 0));
		 request.contentType("application/json");
		 Response response = request.get("/libraryid/" + lib.getId());
		
		 System.out.println("StatusCode ************"+ response.getStatusCode() + "**"
		 +lib.getAccountId());
		 assertEquals(200, response.getStatusCode());

		
	}
	@Test
	public void getPendingLibrariestest() throws JsonParseException, JsonMappingException, IOException {

		 RestAssured.port = 8766;
		 RequestSpecification request = RestAssured.given();
		 Library lib = libraryService.addNewLibrary(new Library("New Library 4",
		 Status.PENDING, 1100, 0));
		 request.contentType("application/json");
		 Response response = request.get("/status/pending");		
		 System.out.println("StatusCode ************"+ response.getStatusCode() + "**"
		 +lib.getStatus());
		 assertEquals(200, response.getStatusCode());
		
	}
	
	@Test
	public void getPrivateLibrariestest() throws JsonParseException, JsonMappingException, IOException {

		 RestAssured.port = 8766;
		 RequestSpecification request = RestAssured.given();
		 Library lib = libraryService.addNewLibrary(new Library("New Library 4",
		 Status.PRIVATE, 1120, 0));
		 request.contentType("application/json");
		 Response response = request.get("/status/private");		
		 System.out.println("StatusCode ************"+ response.getStatusCode() + "**"
		 +lib.getStatus());
		 assertEquals(200, response.getStatusCode());
		
	}
	@Test
	public void getPublicLibrariestest() throws JsonParseException, JsonMappingException, IOException {

		 RestAssured.port = 8766;
		 RequestSpecification request = RestAssured.given();
		 Library lib = libraryService.addNewLibrary(new Library("New Library 4",
		 Status.PENDING, 1110, 0));
		 request.contentType("application/json");
		 Response response = request.get("/status/public");		
		 System.out.println("StatusCode ************"+ response.getStatusCode() + "**"
		 +lib.getStatus());
		 assertEquals(200, response.getStatusCode());
		
	}



}
