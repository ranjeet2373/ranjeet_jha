package com.ustglobal.lms.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.lms.dao.LibraryDAO;
import com.ustglobal.lms.dto.AdminBean;
import com.ustglobal.lms.dto.BookBean;
import com.ustglobal.lms.dto.LibraryResponse;
import com.ustglobal.lms.dto.StudentBean;
import com.ustglobal.lms.service.LibraryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LibraryController {
	
	@Autowired
	private LibraryService service;
	
	@PostMapping(path="/registeradmin", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse addAdmin(@RequestBody AdminBean bean) {
		LibraryResponse response= new LibraryResponse();
		if(service.registreLibrarian(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data added to the db");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not added to the db");
		}
		return response;
	}//REGISTER ADMIN
	
	@PostMapping(path="/registerstudent", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse addStudent(@RequestBody StudentBean bean) {
		LibraryResponse response= new LibraryResponse();
		if(service.registerStudent(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data added to the db");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not added to the db");
		}
		return response;
	}//REGISTER STUDENT
	
	@PutMapping(path = "/updateadmin",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse modifyAdmin(@RequestBody AdminBean bean) {
		LibraryResponse response = new LibraryResponse();
		if(service.updateLibrarian(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data updated to the db");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not updated to the db");
		}
		return response;
	}//End of Update Admin
	
	
	@DeleteMapping(path="/deleteadmin",produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse deleteAdmin(@RequestParam("id") int id) {
		LibraryResponse response = new LibraryResponse();
		if(service.deleteLibrarian(id)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data deleted from the db");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not deleted from the db");
		}
		return response;
	}
	@PostMapping(path="/loginstudent",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse loginStudent(StudentBean bean) {
		LibraryResponse response = new LibraryResponse();
		StudentBean studentBean = service.loginStudent(bean);
		if(studentBean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Login successfull");
		}else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Invalid rollno and password");
		}
		return response;
	}
	@PostMapping(path="/loginadmin",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse loginAdmin(AdminBean bean) {
		LibraryResponse response = new LibraryResponse();
		AdminBean adminBean = service.loginLibrarian(bean);
		if(adminBean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Login successfull");
		}else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Invalid rollno and password");
		}
		return response;
	}
	
	@PostMapping(path = "/addbook",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse addBook(@RequestBody BookBean bean) {
		LibraryResponse response = new LibraryResponse();
		if(service.addBook(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("book is added in the db");
		}else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("book is not added in the db");
		}
		return response;
		
	}
	
	@GetMapping(path = "/searchbook", produces = MediaType.APPLICATION_JSON_VALUE )
	public LibraryResponse searchBook(@RequestParam("bid") int bid) {
		LibraryResponse response = new LibraryResponse();
		BookBean bookBean = service.searchBook(bid);
		if(bookBean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("book is available in db");
			response.setBookbean(Arrays.asList(bookBean));
		}else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("book is not found");
		}
		return response;
		
	}
	
	
	
	
	
	

}
