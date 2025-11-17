package org.jsp.datingapp.controller;


import org.jsp.datingapp.dto.MatchResponse;
import org.jsp.datingapp.entity.User;
import org.jsp.datingapp.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
    private MatchService matchService;
    
   

    // Create user
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return matchService.saveUser(user);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return matchService.getUserById(id);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return matchService.getAllUsers();
    }

    // Update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        return matchService.updateUser(user);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        matchService.deleteUser(id);
        return "User deleted successfully!";
    }

    // Get top matches
    @GetMapping("/matches/{userId}")
    public List<MatchResponse> getTopMatches(@PathVariable int userId,
                                             @RequestParam(defaultValue = "2") int topN) {
        return matchService.findMatches(userId, topN);
    }
}
