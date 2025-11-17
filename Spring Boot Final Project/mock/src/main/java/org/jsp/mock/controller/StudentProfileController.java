package org.jsp.mock.controller;

import org.jsp.mock.StudentProfile;
import org.jsp.mock.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/studentprofiles")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @PostMapping
    public ResponseEntity<?> saveStudentProfile(@RequestBody StudentProfile studentProfile) {
        return studentProfileService.saveStudentProfile(studentProfile); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentProfileById(@PathVariable int id) {
        return studentProfileService.findStudentProfileById(id);
    }

    @GetMapping
    public ResponseEntity<?> findAllStudentProfiles() {
        return studentProfileService.findAllStudentProfiles();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStudentProfile(@PathVariable int id, @RequestBody StudentProfile studentProfile) {
        return studentProfileService.updateStudentProfile(id, studentProfile);
    }
}
