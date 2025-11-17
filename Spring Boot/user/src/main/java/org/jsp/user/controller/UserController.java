//package org.jsp.user.controller;
//
//import java.util.List;
//import java.util.Optional;
//
////import org.apache.catalina.User;
//import org.jsp.user.entity.User;
//import org.jsp.user.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/users")
//
//public class UserController {
//	
//	@Autowired
//	UserRepository repo;
//	
////	@RequestMapping("/save")
//	@PostMapping //("/users")  //use post in postman  save
//	public User saveUser(@RequestBody User user) {
//		
//		return repo.save(user);
//	}
//	
//	@PutMapping //("/users") // use put in postman  //update
//	public User updateUser(@RequestBody User user) {
//		return repo.save(user);  //in json shold send id for update ie "id":1
//		
//	}
//	
//	@GetMapping //("/users") //use get in postman //findAll
//	public List<User> findAll() {
//		return repo.findAll();
//	}
//	
//	
//	//**important methods isPresent isEmpty get methods
//	@GetMapping //("/users") //use get in postman // findById
//	public User findById(@RequestParam int id) {
//
//		Optional<User> optional =repo.findById(id);
//		
////		if(optional.isPresent()) {
////			User user=optional.get();//get back user object
////			return user;
////		}
////		else {
////			return null;
////		}
//		
//		if(optional.isEmpty()) 
//			return null;
//		//one statement so else  and blocks is not used
//			return optional.get(); //get back user object
//	
//	}
//	
//	@GetMapping //("/users/{id}") //use get in postman  //findbyid
//	public User findByIds(@PathVariable int id) {
//
//		Optional<User> optional =repo.findById(id);
//		
//		if(optional.isPresent()) {
//			User user=optional.get();
//			return user;
//		}
//		else {
//			return null;
//		}
//	
//	}
//	
//	
//	@DeleteMapping //("/users/{id}") //use delete in post  //delete
//	public String deleteById(@PathVariable int id) {
//		
//		Optional<User> optional=repo.findById(id);
//		if(optional.isPresent()) {
//	repo.deleteById(id);
//		return "user deleted successfully";
//		}
//		else {
//			return "invalid id";
//		}
//		
//	}
//
//
//}
//




//refer this it is working properly from chat gpt top one not working error it is

//package org.jsp.user.controller;
//
//import java.util.List;
//import java.util.Optional;
//import org.jsp.user.entity.User;
//import org.jsp.user.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    UserRepository repo;
//
//    // Save a new user
//    @PostMapping
//    public User saveUser(@RequestBody User user) {
//        return repo.save(user);
//    }
//
//    // Update an existing user
//    @PutMapping
//    public User updateUser(@RequestBody User user) {
//        return repo.save(user);
//    }
//
//    // Find all users
//    @GetMapping
//    public List<User> findAll() {
//        return repo.findAll();
//    }
//
//    // Find user by ID using RequestParam
//    @GetMapping("/find")
//    public User findById(@RequestParam int id) {
//        Optional<User> optional = repo.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            return null;
//        }
//    }
//
//    // Find user by ID using PathVariable
//    @GetMapping("/{id}")
//    public User findByIds(@PathVariable int id) {
//        Optional<User> optional = repo.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            return null;
//        }
//    }
//
//    // Delete a user by ID
//    @DeleteMapping("/{id}")
//    public String deleteById(@PathVariable int id) {
//        Optional<User> optional = repo.findById(id);
//        if (optional.isPresent()) {
//            repo.deleteById(id);
//            return "User deleted successfully";
//        } else {
//            return "Invalid ID";
//        }
//    }
//}
//


package org.jsp.user.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.user.entity.User;
import org.jsp.user.repository.UserRepository;
import org.jsp.user.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repo;

    @PostMapping
    public ResponseStructure<User> saveUser(@RequestBody User user) {
        User savedUser = repo.save(user);
        return new ResponseStructure<>(200, "User saved successfully", savedUser);
    }

    @PutMapping
    public ResponseStructure<User> updateUser(@RequestBody User user) {
        User updatedUser = repo.save(user);
        return new ResponseStructure<>(200, "User updated successfully", updatedUser);
    }

    @GetMapping
    public ResponseStructure<List<User>> findAll() {
        List<User> users = repo.findAll();
        return new ResponseStructure<>(200, "Users fetched successfully", users);
    }

    @GetMapping("/find")
    public ResponseStructure<User> findById(@RequestParam int id) {
        Optional<User> optional = repo.findById(id);
        if (optional.isPresent()) {
            return new ResponseStructure<>(200, "User found", optional.get());
        } else {
            return new ResponseStructure<>(404, "User not found", null);
        }
    }

    @GetMapping("/{id}")
    public ResponseStructure<User> findByIds(@PathVariable int id) {
        Optional<User> optional = repo.findById(id);
        if (optional.isPresent()) {
            return new ResponseStructure<>(200, "User found", optional.get());
        } else {
            return new ResponseStructure<>(404, "User not found", null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteById(@PathVariable int id) {
        Optional<User> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return new ResponseStructure<>(200, "User deleted successfully", null);
        } else {
            return new ResponseStructure<>(404, "Invalid ID", null);
        }
    }
    

}
