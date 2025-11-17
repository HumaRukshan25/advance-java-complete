package org.jsp.eventt.controller;


import java.time.LocalDateTime;
import java.util.List;
import org.jsp.eventt.entity.Event;
import org.jsp.eventt.responsestructure.ResponseStructure;
import org.jsp.eventt.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class EventController {
//
//	@Autowired
//	EventRepository repository;
//
//	@GetMapping("/hi")
//	public String hi() {
//		return "hello from event app";
//	}
//
//	@PostMapping("/events")
//	public ResponseStructure<Event> saveEvent(@RequestBody Event event) {//Event
////		return repository.save(event);
//		event=repository.save(event);
//		ResponseStructure<Event> structure=new ResponseStructure<Event>();
//		structure.setHttpStatus(200);
//		structure.setMessage("event saved successfully");
//		structure.setBody(event);
//		return structure;
//
//	}
//old
//	@GetMapping("/events")
//	public ResponseEntity<ResponseStructure<List<Event>>> findAllEvents() {
//	    List<Event> el = repository.findAll();
//	    
//	    ResponseStructure<List<Event>> structure = new ResponseStructure<>();
//	    
//	    if (el.isEmpty()) {
//	        structure.setHttpStatus(404);
//	        structure.setMessage("No events found in the database");
//	        structure.setBody(el);
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(structure);
//	    } else {
//	        structure.setHttpStatus(200);
//	        structure.setMessage("All events found successfully");
//	        structure.setBody(el);
//	        return ResponseEntity.ok(structure);
//	    }
//	}
//
//	
//	
//		
////		if(el.size()>0) {
////			ResponseStructure<List<Event>> structure=new ResponseStructure<>();
////			structure.setHttpStatus(200);
////			structure.setMessage("all events found successfully");
////			structure.setBody(el);
////			return structure;	
////		}
////		else {
////			ResponseStructure<List<Event>> structure=new ResponseStructure<>();
////			structure.setHttpStatus(404);
////			structure.setMessage("no events found in the database");
////			structure.setBody(el);
////			return structure;
////			
////		}
//
//	
//
//	@GetMapping("/events/{id}")
//	public ResponseStructure<Event> findEventById(@PathVariable int id) {
//		Optional<Event> optional = repository.findById(id);
//		
//		ResponseStructure<Event> structure=new ResponseStructure<Event>();
//		
//		if (optional.isEmpty()) {
////			return null;
//			structure.setHttpStatus(404);
//			structure.setMessage("no events found in the database with that id");
//			structure.setBody(null);
//			return structure;
//		
//			
//		} else {
////			Event event = optional.get();
////
////			return event;
//			structure.setHttpStatus(200);
//			structure.setMessage("event found successfully");
//			structure.setBody(optional.get());
//			return structure;	
//			
//
//		}
//	}
//
//	
//	
//	@DeleteMapping("/events/{id}")
//	public ResponseStructure<String> deleteEventById(@PathVariable int id) {//String
//	    Optional<Event> optional = repository.findById(id);
//	    ResponseStructure<String> structure = new ResponseStructure<>();
//
//	    if (optional.isEmpty()) {
////			return "invalid id entered";
//	        structure.setHttpStatus(404);
//	        structure.setMessage("No events found in the database with that ID");
//	        structure.setBody(null); // Body can be null for not found
//	    } else {
////			repository.deleteById(id);
////
////			return "data sucessfully deleted";
//	        repository.deleteById(id); // Deleting the event
//	        structure.setHttpStatus(200);
//	        structure.setMessage("Data deleted successfully");
//	        structure.setBody("Event with ID " + id + " has been deleted.");
//	    }
//
//	    return structure;
//	}
//
//
//	//@GetMapping("/events/guest/{guest}")
//	//public List<Event> findEventsByGuest(@PathVariable String guest) {
//	//	
////		return repository.findByGuest(guest);
//////			List<Event> events = new ArrayList<>();
//////			List<Event> el = repository.findAll();
//////			for (Event e : el) {
//////				if (e.getGuest().equalsIgnoreCase(guest)) {
//////					events.add(e);
//////				}
//////			}
//////			return events;
//	//
////		}	
//
//		@GetMapping("/events/guest/{guest}")
//		public ResponseStructure<List<Event>> findEventsByGuest(@PathVariable String guest) {//List<Event> 
//		    List<Event> events = repository.findByGuest(guest);
//		    ResponseStructure<List<Event>> structure = new ResponseStructure<>();
//
//		    if (events.isEmpty()) {
//		        structure.setHttpStatus(404);
//		        structure.setMessage("No events found for the guest: " + guest);
//		        structure.setBody(null); // No events found
//		    } else {
//		        structure.setHttpStatus(200);
//		        structure.setMessage("Events retrieved successfully");
//		        structure.setBody(events); // Events found
//		    }
//
//		    return structure;
//		}
//
//
//	
//	//find event based on title
//	
//	@GetMapping("/events/title/{title}")
//	public List<Event> findEventsByTitle(@PathVariable String title) {
//		
//		return repository.findByTitle(title);
//		
//		
////	    List<Event> events = new ArrayList<>();
////	    List<Event> allEvents = repository.findAll();
////	    for (Event e : allEvents) {
////	        if (e.getTitle().equalsIgnoreCase(title)) {
////	            events.add(e);
////	        }
////	    }
////	    return events;
//		
//	}
//	
//
//}

/// attended repeat 15/04/2025


@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseStructure<List<Event>> findAllEvents() {
      
        return service.getAllEvents();
    }

    @PostMapping
    public ResponseStructure<Event> saveEvent(@RequestBody Event event) {
       
        return service.saveEvent(event);
    }

    @GetMapping("/{id}")
    public ResponseStructure<Event> findEventById(@PathVariable int id) {
      
        return service.getEventById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteEventById(@PathVariable int id) {
   
        return service.deleteEventById(id);
    }

    @GetMapping("/guest/{guest}")
    public ResponseStructure<List<Event>> findEventsByGuest(@PathVariable String guest) {
      
        return service.findEventsByGuest(guest);
    }

    @GetMapping("/title/{title}")
    public ResponseStructure<List<Event>> findEventsByTitle(@PathVariable String title) {
       
        return service.findEventsByTitle(title);
    }
    
    @GetMapping("/eventfromdate")
    public ResponseEntity<ResponseStructure<List<Event>>> getEventsFromDate(
            @RequestParam String fromDate) {
        LocalDateTime from = LocalDateTime.parse(fromDate);
        return service.getEventsFromDate(from);
    }




}
