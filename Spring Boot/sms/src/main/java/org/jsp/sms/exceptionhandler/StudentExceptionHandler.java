package org.jsp.sms.exceptionhandler;

import org.jsp.sms.exceptionclassess.InvalidEmailException;
import org.jsp.sms.exceptionclassess.InvalidStudentIdException;
import org.jsp.sms.exceptionclassess.NoStudentException;
import org.jsp.sms.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<?> invalidEmailExceptionHandler(InvalidEmailException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value()); 
		structure.setMessage("invalid email");
		structure.setBody("unable to find student");

		return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidStudentIdException.class)  
	// delete and get id both in same for code optimization localhost:8080/students/10
	public ResponseEntity<?> invalidStudentIdExceptionHandler(InvalidStudentIdException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value()); 
		structure.setMessage("invalid id");
		structure.setBody(e.getMessage());
		return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(NoStudentException.class)  
	// change database to getno student
	public ResponseEntity<?> NoStudentExceptionHandler(NoStudentException e) {
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value()); 
		structure.setMessage("invalid");
		structure.setBody(e.getMessage());
		return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND) ;
	}

	
}
