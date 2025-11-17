package org.jsp.mock.service;

import org.springframework.http.ResponseEntity;
import org.jsp.mock.StudentProfile;

public interface StudentProfileService {

    ResponseEntity<?> findAllStudentProfiles();

    ResponseEntity<?> findStudentProfileById(int id);

    ResponseEntity<?> updateStudentProfile(int id, StudentProfile studentProfile); 

    ResponseEntity<?> saveStudentProfile(StudentProfile studentProfile);


}
