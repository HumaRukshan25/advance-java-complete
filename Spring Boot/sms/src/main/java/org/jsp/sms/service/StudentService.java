//package org.jsp.sms.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.jsp.sms.dao.StudentDao;
//import org.jsp.sms.entity.Student;
//import org.jsp.sms.responsestructure.ResponseStructure;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//
//public class StudentService {
//	@Autowired
//	private StudentDao dao;
//
//	public ResponseStructure<Student> saveStudent(Student student) {
//		student = dao.saveStudent(student);
//
//		ResponseStructure<Student> structure = new ResponseStructure<>();
//
//		structure.setHttpStatus(HttpStatus.CREATED.value());// 200 success 201 created 202 accepted
//		structure.setMessage("student saved successfully");
//		structure.setBody(student);
//		return structure;
//	}
//
//	public ResponseStructure<List<Student>> findAllStudents() {
//		List<Student> students = dao.findAllStudents();
//		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
//		if (students.isEmpty()) {
//			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("No students available in the database table.");
//			structure.setBody(students);
//		} else {
//			structure.setHttpStatus(HttpStatus.OK.value());
//			structure.setMessage("All students available in the database table.");
//			structure.setBody(students);
//		}
//		return structure;
//	}
//
//	public ResponseStructure<Student> findStudentById(int id) {
//		// TODO Auto-generated method stub
//		Optional<Student> optional = dao.findStudentById(id);
//		ResponseStructure<Student> structure = new ResponseStructure<>();
//		if (optional.isEmpty()) {
//			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("invalid student id");
//			structure.setBody(optional.get());
//			return structure;
//		} else {
//			structure.setHttpStatus(HttpStatus.OK.value());
//			structure.setMessage("student  found successfully ");
//			structure.setBody(optional.get());
//			return structure;
//
//		}
//	}
//
//	public ResponseStructure<Student> deleteStudentById(int id) {
//		Optional<Student> optional=dao.findStudentById(id);
//		ResponseStructure<Student> structure = new ResponseStructure<>();
//		
//		if (optional.isEmpty()) {
//			structure.setHttpStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("invalid student id");
//			structure.setBody("unable todelete the student");
//			return structure;
//		} else {
//			dao.deleteStudentById(id);
//			structure.setHttpStatus(HttpStatus.OK.value());
//			structure.setMessage("student  found successfully ");
//			structure.setBody("deleted successfully");
//			return structure;
//
//		}
//	}
//
//}

package org.jsp.sms.service;

import java.util.List;
import java.util.Optional;

import org.jsp.sms.dao.StudentDao;
import org.jsp.sms.dto.AuthStd;
import org.jsp.sms.entity.Student;
import org.jsp.sms.exceptionclassess.InvalidEmailException;
import org.jsp.sms.exceptionclassess.InvalidStudentIdException;
import org.jsp.sms.exceptionclassess.NoStudentException;
import org.jsp.sms.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service // Add this annotation extra info to developer  in service layer
public class StudentService {
	@Autowired
	private StudentDao dao;

	public ResponseStructure<Student> saveStudent(Student student) {
		student = dao.saveStudent(student);

		ResponseStructure<Student> structure = new ResponseStructure<>();
		structure.setHttpStatus(HttpStatus.CREATED.value()); // 201 created
		structure.setMessage("student saved successfully");
		structure.setBody(student);
		return structure;
	}

//ResponseEntity<ResponseStructure<List<Student>>>
	
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudents() {
		List<Student> students = dao.findAllStudents();
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		if (students.isEmpty()) {
//			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("No students available in the database table.");
//			structure.setBody(students);
//			return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
			
			throw new NoStudentException("no students in database");
		} else {
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setMessage("All students available in the database table.");
			structure.setBody(students);
			return new ResponseEntity(structure, HttpStatus.OK);
		}

	}

	public ResponseStructure<Student> findStudentById(int id) {
		Optional<Student> optional = dao.findStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<>();
		if (optional.isEmpty()) {
//            structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//            structure.setMessage("invalid student id");
//            structure.setBody(null); // Fix the null-pointer issue
//            return structure;

			throw new InvalidStudentIdException("invalid student id enable to find student with that id");

		} else {
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setMessage("student found successfully ");
			structure.setBody(optional.get());
			return structure;
		}
	}

	public ResponseStructure<Student> deleteStudentById(int id) {
		Optional<Student> optional = dao.findStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<>();

		if (optional.isEmpty()) {
//            structure.setHttpStatus(HttpStatus.BAD_REQUEST.value());
//            structure.setMessage("invalid student id");
//            structure.setBody(null); // Adjusted for consistency
//            return structure;
			throw new InvalidStudentIdException("invalid student id enable to delete");
		} else {
			dao.deleteStudentById(id);
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setMessage("student deleted successfully ");
			structure.setBody(optional.get());
			return structure;
		}
	}

	public ResponseStructure<Student> findStudentByEmail(String email) {
		Optional<Student> optional = dao.findStudentByEmail(email);
		ResponseStructure<Student> structure = new ResponseStructure<>();
		if (optional.isEmpty()) {
//            structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//            structure.setMessage("No student found with the provided email.");
//            structure.setBody(null);
//            return structure;

			throw new InvalidEmailException("invalid email unable to find student");
		} else {
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setMessage("Student found successfully.");
			structure.setBody(optional.get());
			return structure;
		}

	}

//    public ResponseStructure<Student> findStudentByPhone(String phone) {
//        Optional<Student> optional = dao.findStudentByPhone(phone);
//        ResponseStructure<Student> structure = new ResponseStructure<>();
//        if (optional.isEmpty()) {
//            structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//            structure.setMessage("No student found with the provided phone number.");
//            structure.setBody(null);
//        } else {
//            structure.setHttpStatus(HttpStatus.OK.value());
//            structure.setMessage("Student found successfully.");
//            structure.setBody(optional.get());
//        }
//        return structure;
//    }

	// http://localhost:8080/students/login?email=abc@gmail.com&password=123

	// inpostman use get localhost:8080/students?email=push1@11424&password=123
	public ResponseEntity<ResponseStructure<List<Student>>> findStudentByEmailAndPassword(AuthStd auth) {
		Optional<Student> optional = dao.findStudentByEmailAndPassword(auth.getEmail(), auth.getPassword());
		ResponseStructure<Student> structure = new ResponseStructure<>();

		if (optional.isEmpty()) {
//   		 structure.setHttpStatus(HttpStatus.BAD_REQUEST.value());
//   		 structure.setMessage("invalid ");
//   		 structure.setBody(null);
//   		 return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
			throw new RuntimeException("invalid credientials");
		}

		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setMessage("login successfull ");
		structure.setBody(optional.get());
		return new ResponseEntity(structure, HttpStatus.OK);
	}

}
