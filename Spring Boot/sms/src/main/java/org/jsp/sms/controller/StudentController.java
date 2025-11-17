package org.jsp.sms.controller;

import java.util.List;

import org.jsp.sms.dto.AuthStd;
import org.jsp.sms.entity.Student;
import org.jsp.sms.responsestructure.ResponseStructure;
import org.jsp.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


	@RestController
	@RequestMapping("/students")// Base URL for all routes in this controller
	public class StudentController {
	   
    @Autowired
    private StudentService service;

    // Login endpoint
//	@GetMapping("/login")
    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<List<Student>>> findStudentByEmailAndPassword(@RequestBody AuthStd auth) {
//		System.out.println(auth.getEmail());
//		System.out.println(auth.getPassword());
//		return null;
    	return service.findStudentByEmailAndPassword(auth);
    }

   
   
    // Save a new student
    @PostMapping
    public ResponseStructure<Student> saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // Find all students
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Student>>> findAllStudents() {
        return service.findAllStudents();
    }
  

     //Find a student by ID
    @GetMapping("/{id}")
    public ResponseStructure<Student> findStudentById(@PathVariable int id) {
        return service.findStudentById(id);
    }
    
    
    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseStructure<Student> deleteStudentById(@PathVariable int id) {
        return service.deleteStudentById(id);
    }

    // Find a student by email
    @GetMapping("/email/{email}")
    public ResponseStructure<Student> findStudentByEmail(@PathVariable String email) {
        return service.findStudentByEmail(email);
    }
    
//	@GetMapping("/phone/{phone}")
//	public ResponseStructure<Student> findStudentByPhone(@PathVariable String phone) {
//		return service.findStudentByPhone(phone);
//	}
    
}

