package org.jsp.eventt.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.jsp.eventt.entity.Event;
import org.jsp.eventt.entity.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EventRepository  extends JpaRepository<Event, Integer>{

	@Query("select e from Event e where e.title=:title")
	List<Event> findByTitle(String title);	

//	List<Event> findByTitle(String title);

	List<Event> findByGuest(String guest);
	
	List<Event> findByStatus(EventStatus status);
	
	List<Event> findByEventDateTimeBetween(LocalDateTime start, LocalDateTime end);


	
	
}


