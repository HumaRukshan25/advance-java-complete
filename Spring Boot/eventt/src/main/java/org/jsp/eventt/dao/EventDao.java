

package org.jsp.eventt.dao;

import org.jsp.eventt.entity.Event;
import org.jsp.eventt.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventDao {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event saveEvent(Event event) {
        return repository.save(event);
    }

    public Optional<Event> getEventById(int id) {
        return repository.findById(id);
    }

    public void deleteEventById(int id) {
        repository.deleteById(id);
    }

    public List<Event> findEventsByGuest(String guest) {
        return repository.findByGuest(guest);
    }

    public List<Event> findEventsByTitle(String title) {
        return repository.findByTitle(title);
    }
}
