package com.endava.ticketsjavabackend.repository;

import com.endava.ticketsjavabackend.model.Customer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, Integer> {
}
