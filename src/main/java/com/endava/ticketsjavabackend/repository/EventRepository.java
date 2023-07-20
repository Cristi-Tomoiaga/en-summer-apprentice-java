package com.endava.ticketsjavabackend.repository;

import com.endava.ticketsjavabackend.model.Event;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends ListCrudRepository<Event, Integer> {
    List<Event> findEventsByVenue_IdAndEventType_Name(Integer venueId, String eventTypeName);
    List<Event> findEventsByVenue_Id(Integer venueId);
    List<Event> findEventsByEventType_Name(String eventTypeName);
}
