//package com.linkediin.linkedinlite;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface PersonRepository extends JpaRepository<Person, Integer> {
//
//}


package com.linkediin.linkedinlite;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);

	List<Person> findByEmail(String email);
	
	
	// @Query("select p from Person p where p.email =:email and p.password = :password")
    
    @Query("select p from Person p where p.email = ?1 and p.password = ?2")
	Optional<Person> login(String email, String password);
	
	

}
