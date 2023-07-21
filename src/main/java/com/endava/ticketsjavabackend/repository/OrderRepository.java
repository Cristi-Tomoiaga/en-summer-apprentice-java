package com.endava.ticketsjavabackend.repository;

import com.endava.ticketsjavabackend.model.Order;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, Integer> {
    List<Order> findOrdersByCustomer_Id(Integer customerId);
}
