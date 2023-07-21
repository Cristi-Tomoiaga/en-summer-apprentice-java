package com.endava.ticketsjavabackend.repository;

import com.endava.ticketsjavabackend.model.TicketCategory;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCategoryRepository extends ListCrudRepository<TicketCategory, Integer> {
}
