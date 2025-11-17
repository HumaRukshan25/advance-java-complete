package com.infosys.lms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.lms.entity.User;
import com.infosys.lms.repository.UserRepository;

@Repository
public class UserDao {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteUserById(int id) {
        repo.deleteById(id);
    }

    public List<User> getUserByName(String name) {
        return repo.findByName(name);
    }

    public User getUserByEmail(String email) {
        return repo.findByEmail(email);
    }

    public User login(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }
}

