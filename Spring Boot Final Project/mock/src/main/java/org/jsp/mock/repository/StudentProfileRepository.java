package org.jsp.mock.repository;

import org.jsp.mock.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {
}
