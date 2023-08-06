package com.endava.ticketsjavabackend.repository;

import com.endava.ticketsjavabackend.model.Event;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends ListCrudRepository<Event, Integer> {
    List<Event> findEventsByVenue_LocationContainingAndEventType_NameContaining(String venueLocation, String eventTypeName);
    List<Event> findEventsByVenue_LocationContaining(String venueLocation);
    List<Event> findEventsByEventType_NameContaining(String eventTypeName);
}
