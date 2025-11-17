package org.jsp.mock.DaoImp;

import org.jsp.mock.StudentProfile;
import org.jsp.mock.Dao.StudentProfileDao;
import org.jsp.mock.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileDaoImpl implements StudentProfileDao {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Override
    public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public List<StudentProfile> findAllStudentProfiles() {
        return studentProfileRepository.findAll();
    }

    @Override
    public Optional<StudentProfile> findStudentProfileById(int id) {
        return studentProfileRepository.findById(id);
    }
}
