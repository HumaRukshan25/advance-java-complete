package org.jsp.eventt.service;

import org.jsp.eventt.entity.Event;
import org.jsp.eventt.repository.EventRepository;
import org.jsp.eventt.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public ResponseStructure<List<Event>> getAllEvents() {
        List<Event> events = repository.findAll();

        return events.isEmpty()
                ? ResponseStructure.<List<Event>>builder()
                    .httpStatus(HttpStatus.NOT_FOUND.value())
                    .message("No events found in the database")
                    .body(null)
                    .build()
                : ResponseStructure.<List<Event>>builder()
                    .httpStatus(HttpStatus.OK.value())
                    .message("All events found successfully")
                    .body(events)
                    .build();
    }

    public ResponseStructure<Event> saveEvent(Event event) {
        Event saved = repository.save(event);

        return ResponseStructure.<Event>builder()
                .httpStatus(HttpStatus.OK.value())
                .message("Event saved successfully")
                .body(saved)
                .build();
    }

    public ResponseStructure<Event> getEventById(int id) {
        Optional<Event> optional = repository.findById(id);

        return optional.map(event ->
                ResponseStructure.<Event>builder()
                        .httpStatus(HttpStatus.OK.value())
                        .message("Event found successfully")
                        .body(event)
                        .build()
        ).orElseGet(() ->
                ResponseStructure.<Event>builder()
                        .httpStatus(HttpStatus.NOT_FOUND.value())
                        .message("No event found with that ID")
                        .body(null)
                        .build()
        );
    }

    public ResponseEntity<ResponseStructure<String>> deleteEventById(int id) {
        Optional<Event> optional = repository.findById(id);

        // Check if the event exists
        return optional.map(event -> {
            repository.deleteById(id); // Delete the event
            // Build the ResponseStructure and return as ResponseEntity
            ResponseStructure<String> structure = ResponseStructure.<String>builder()
                    .httpStatus(HttpStatus.OK.value())
                    .message("Event deleted successfully")
                    .body("Event with ID " + id + " has been deleted.")
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(structure); // Wrap in ResponseEntity
        }).orElseGet(() -> {
            // If event not found, build ResponseStructure and return as ResponseEntity
            ResponseStructure<String> structure = ResponseStructure.<String>builder()
                    .httpStatus(HttpStatus.NOT_FOUND.value())
                    .message("No event found with that ID")
                    .body(null)
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(structure); // Wrap in ResponseEntity
        });
    }


    public ResponseStructure<List<Event>> findEventsByGuest(String guest) {
        List<Event> events = repository.findByGuest(guest);

        return events.isEmpty()
                ? ResponseStructure.<List<Event>>builder()
                    .httpStatus(HttpStatus.NOT_FOUND.value())
                    .message("No events found for guest: " + guest)
                    .body(null)
                    .build()
                : ResponseStructure.<List<Event>>builder()
                    .httpStatus(HttpStatus.OK.value())
                    .message("Events retrieved successfully")
                    .body(events)
                    .build();
    }

    public ResponseStructure<List<Event>> findEventsByTitle(String title) {
        List<Event> events = repository.findByTitle(title);

        return events.isEmpty()
                ? ResponseStructure.<List<Event>>builder()
                    .httpStatus(HttpStatus.NOT_FOUND.value())
                    .message("No events found with the title: " + title)
                    .body(null)
                    .build()
                : ResponseStructure.<List<Event>>builder()
                    .httpStatus(HttpStatus.OK.value())
                    .message("Events retrieved successfully")
                    .body(events)
                    .build();
    }
    
    public ResponseEntity<ResponseStructure<List<Event>>> getEventsFromDate(LocalDateTime fromDate) {
        List<Event> events = repository.findByEventDateTimeBetween(fromDate, LocalDateTime.now());

        ResponseStructure<List<Event>> structure = events.isEmpty()
                ? ResponseStructure.<List<Event>>builder()
                    .httpStatus(HttpStatus.NOT_FOUND.value())
                    .message("No events found from the given date")
                    .body(null)
                    .build()
                : ResponseStructure.<List<Event>>builder()
                    .httpStatus(HttpStatus.OK.value())
                    .message("Events retrieved successfully from the given date")
                    .body(events)
                    .build();

        return ResponseEntity.status(structure.getHttpStatus()).body(structure);
    }



    
}
