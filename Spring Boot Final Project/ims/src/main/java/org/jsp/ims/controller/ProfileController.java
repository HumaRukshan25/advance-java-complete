package org.jsp.ims.controller;

import org.jsp.ims.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@CrossOrigin 
@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@RequestMapping("/hi")
	public String hi() {
		return "hello from ProfileController";
	}
	
	@PostMapping("/profiles")
	public ResponseEntity<?> saveProfile(@RequestParam MultipartFile file){
		return service.saveProfile(file); 
	}
	
	@GetMapping("/profiles")
	public ResponseEntity<?> findAllProfiles(){
		return service.findAllProfiles();
		
	}

	
}
