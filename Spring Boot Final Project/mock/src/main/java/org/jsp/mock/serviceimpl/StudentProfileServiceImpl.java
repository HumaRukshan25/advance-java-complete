package org.jsp.mock.serviceimpl;

import org.jsp.mock.StudentProfile;
import org.jsp.mock.Dao.StudentProfileDao;
import org.jsp.mock.responsestructure.ResponseStructure;
import org.jsp.mock.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileDao studentProfileDao;

    @Override
    public ResponseEntity<?> saveStudentProfile(StudentProfile studentProfile) {
        studentProfileDao.saveStudentProfile(studentProfile);

        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseStructure.builder()
                        .status(HttpStatus.OK.value())
                        .message("Student Profile Saved Successfully")
                        .body(studentProfile)
                        .build()
        );
    }

    @Override
    public ResponseEntity<?> findAllStudentProfiles() {
        List<StudentProfile> studentProfiles = studentProfileDao.findAllStudentProfiles();
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseStructure.builder()
                        .status(HttpStatus.OK.value())
                        .message("All Student Profiles Found Successfully")
                        .body(studentProfiles)
                        .build()
        );
    }

    @Override
    public ResponseEntity<?> findStudentProfileById(int id) {
        Optional<StudentProfile> optional = studentProfileDao.findStudentProfileById(id);

        if (optional.isEmpty()) {
            throw new RuntimeException("Student Profile Not Found");
        }

        StudentProfile studentProfile = optional.get();
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseStructure.builder()
                        .status(HttpStatus.OK.value())
                        .message("Student Profile Found Successfully")
                        .body(studentProfile)
                        .build()
        );
    }



    @Override
    public ResponseEntity<?> updateStudentProfile(int id, StudentProfile studentProfile) {
        // Find the existing profile by ID
        Optional<StudentProfile> existingProfileOptional = studentProfileDao.findStudentProfileById(id);
        
        // If the profile doesn't exist, return a not found response
        if (existingProfileOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ResponseStructure.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("Student Profile Not Found")
                            .body(null)
                            .build()
            );
        }

        // Get the existing profile
        StudentProfile existingProfile = existingProfileOptional.get();

        // Update fields if they are provided in the request
        if (studentProfile.getYear() != null) {
            existingProfile.setYear(studentProfile.getYear());
        }

        // Save the updated profile back to the database
        studentProfileDao.saveStudentProfile(existingProfile);

        // Return the updated profile with a success message
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseStructure.builder()
                        .status(HttpStatus.OK.value())
                        .message("Student Profile Updated Successfully")
                        .body(existingProfile)
                        .build()
        );
    }


}
