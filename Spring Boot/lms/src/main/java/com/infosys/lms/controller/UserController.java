package com.infosys.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.lms.entity.User;
import com.infosys.lms.responsestructure.ResponseStructure;
import com.infosys.lms.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseStructure<User> saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping
    public ResponseStructure<List<User>> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseStructure<User> getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteUserById(@PathVariable int id) {
        return service.deleteUserById(id);
    }

 //GET /users/name?name=Huma
    
//    @GetMapping("/name")
//    public ResponseStructure<List<User>> getUserByName(@RequestParam String name) {
//        return service.getUserByName(name);
//    }
    
    @PostMapping("/name")
    public ResponseStructure<List<User>> getUserByNameFromBody(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        return service.getUserByName(name);
    }



    @GetMapping("/email")
    public ResponseStructure<User> getUserByEmail(@RequestParam String email) {
        return service.getUserByEmail(email);
    }

    @PostMapping("/login")
    public ResponseStructure<User> login(@RequestBody AuthUser auth) {
        return service.login(auth.getEmail(), auth.getPassword());
    }

}


