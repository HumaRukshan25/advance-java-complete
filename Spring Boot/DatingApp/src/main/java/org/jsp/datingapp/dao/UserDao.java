package org.jsp.datingapp.dao;


import org.jsp.datingapp.entity.User;
import org.jsp.datingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class UserDao {

	@Autowired
    private UserRepository userRepository;

    // Save or Update a user
    public User save(User user) {
        return userRepository.save(user);
    }

    // Find user by ID
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    // Find all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Delete user by ID
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    // Update user - optional if you need to process logic before saving
    public User updateUser(User user) {
        return userRepository.save(user); // Same as save in JPA
    }

 
}
