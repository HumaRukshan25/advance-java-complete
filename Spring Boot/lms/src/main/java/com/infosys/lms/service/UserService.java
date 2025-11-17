package com.infosys.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.lms.dao.UserDao;
import com.infosys.lms.entity.User;
import com.infosys.lms.responsestructure.ResponseStructure;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public ResponseStructure<User> saveUser(User user) {
        User savedUser = dao.saveUser(user);
        return new ResponseStructure<>(200, "User saved successfully", savedUser);
    }

    public ResponseStructure<List<User>> getAllUsers() {
        return new ResponseStructure<>(200, "All users retrieved", dao.getAllUsers());
    }

    public ResponseStructure<User> getUserById(int id) {
        return new ResponseStructure<>(200, "User found", dao.getUserById(id));
    }

    public ResponseStructure<String> deleteUserById(int id) {
        dao.deleteUserById(id);
        return new ResponseStructure<>(200, "User deleted successfully", "Deleted user with ID: " + id);
    }

    public ResponseStructure<List<User>> getUserByName(String name) {
        return new ResponseStructure<>(200, "User(s) by name found", dao.getUserByName(name));
    }

    public ResponseStructure<User> getUserByEmail(String email) {
        return new ResponseStructure<>(200, "User by email found", dao.getUserByEmail(email));
    }

    public ResponseStructure<User> login(String email, String password) {
        User user = dao.login(email, password);
        if (user != null) {
            return new ResponseStructure<>(200, "Login successful", user);
        } else {
            return new ResponseStructure<>(401, "Invalid credentials", null);
        }
    }
}

