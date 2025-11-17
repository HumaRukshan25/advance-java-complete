package org.jsp.mock.Dao;

import java.util.List;
import java.util.Optional;
import org.jsp.mock.StudentProfile;

public interface StudentProfileDao {

    StudentProfile saveStudentProfile(StudentProfile studentProfile);

    List<StudentProfile> findAllStudentProfiles();

    Optional<StudentProfile> findStudentProfileById(int id);
}
