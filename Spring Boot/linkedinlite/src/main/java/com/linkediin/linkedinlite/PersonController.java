package com.linkediin.linkedinlite;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonController {

    @Autowired
    private PersonRepository repo;

    // Save a new person
    @PostMapping("/persons")
    public ResponseStructure<Person> savePerson(@RequestBody Person person) {
     Person  savedPerson= repo.save(person);
       return new ResponseStructure<>(200,"person saved successfully",savedPerson);
    }

    // Get all persons
    @GetMapping("/persons")
    public ResponseStructure<List<Person>> getAllPersons() {

//    	if(repo.findAll().size()==0) {
    	if(repo.findAll().isEmpty()) {
    		 return new ResponseStructure<>(404,"no person present",repo.findAll());
    		
    	}
     return new ResponseStructure<>(200,"list of persons are",repo.findAll());
    }

    // Get person by ID
    @GetMapping("/persons/{id}")
    public ResponseStructure<Object> findById(@PathVariable int id) {
        Optional<Person> optional = repo.findById(id);
        if (optional.isEmpty()) {
            System.out.println("Invalid ID");
            return new ResponseStructure<>(404,"person with id not found",optional);
        } else {
            return  new ResponseStructure<>(200,"person found successfully",optional.get());
        }
    }

    // Get persons by name
    @GetMapping("/persons/name/{name}")
    public ResponseStructure<List<Person>> getPersonsByName(@PathVariable String name) {
        List<Person> byName=repo.findByName(name);
        return new ResponseStructure<>(200,"person found successfully",byName);
    }

    // Get persons by email
    @GetMapping("/persons/email/{email}")
    public ResponseStructure<List<Person>> getPersonsByEmail(@PathVariable String email) {
    	List<Person>  byEmail= repo.findByEmail(email);
    	return new ResponseStructure<>(200,"person found successfully with that email",byEmail);
    }

   
    
 // Delete person by ID
    @DeleteMapping("/persons/{id}")
    public ResponseStructure<String> deletePerson(@PathVariable int id) {
        Optional<Person> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return new ResponseStructure<>(200, "Person with ID " + id + " deleted successfully.", null);
        } else {
            return new ResponseStructure<>(404, "Person with ID " + id + " not found.", null);
        }
    }

    
    
 // Login
    @GetMapping("/persons/login1") // Use POST instead of GET for login with @RequestBody
    public ResponseStructure<Object> login(@RequestBody AuthPerson ap) {
        Optional<Person> optional = repo.login(ap.getEmail(), ap.getPassword());
        if (optional.isEmpty()) {
            return new ResponseStructure<>(401, "Invalid credentials", null);
        }
        return new ResponseStructure<>(200, "Login successful", optional.get());
    }

}
