package com.endava.ticketsjavabackend.repository;

import com.endava.ticketsjavabackend.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends ListCrudRepository<Event, Integer> {
    @Query("select e from Event e where e.venue.location like %?1% and e.eventType.name like %?2% and e.availableSeats > 0")
    List<Event> findAvailableEventsByVenueLocationAndEventType(String venueLocation, String eventTypeName);

    @Query("select e from Event e where e.venue.location like %?1% and e.availableSeats > 0")
    List<Event> findEventsByVenueLocation(String venueLocation);

    @Query("select e from Event e where e.eventType.name like %?1% and e.availableSeats > 0")
    List<Event> findEventsByEventType(String eventTypeName);

    @Query("select e from Event e where e.availableSeats > 0")
    List<Event> findAvailableEvents();
}
