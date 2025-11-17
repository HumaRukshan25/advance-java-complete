package com.infosys.lms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	    List<User> findByName(String name);
	    User findByEmail(String email);
	    User findByEmailAndPassword(String email, String password);
	

}
