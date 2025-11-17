package org.jsp.ums;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping("/hi")
    public String hi() {
        return "hello from user controller";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hi from spring boot application";
    }

    @PostMapping
    public User saveUser(@RequestBody User u) {
        return repo.save(u);
    }
    
    
    //07/04/2025----------------------- done in previous project only
    
    // Get user by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return repo.findById(id);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/name/{name}")
    public List<User> getByName(@PathVariable String name) {
        return repo.findByName(name);
    }

    @GetMapping("/email/{email}")
    public List<User> getByEmail(@PathVariable String email) {
        return repo.findByEmail(email);
    }

//    @GetMapping("/login/{email}/{password}")
//    public List<User> login(@PathVariable String email, @PathVariable String password) {
//        return repo.findByEmailAndPassword(email, password);
//    }
    
    @GetMapping("/login/{email}/{password}")
    public Object login(@PathVariable String email, @PathVariable String password) {
        List<User> users = repo.findByEmailAndPassword(email, password);
        if (!users.isEmpty()) {
        	System.out.println("login successful");
        	 return repo.findByEmailAndPassword(email, password);
           
        } else {
            return "Invalid Email or Password.";
        }
    }


}
