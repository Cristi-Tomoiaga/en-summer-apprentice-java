package com.endava.ticketsjavabackend.service;

import com.endava.ticketsjavabackend.exception.InvalidIdException;
import com.endava.ticketsjavabackend.exception.InvalidNumberOfTicketsException;
import com.endava.ticketsjavabackend.exception.InvalidTicketCategoryException;
import com.endava.ticketsjavabackend.exception.UnavailableSeatsException;
import com.endava.ticketsjavabackend.mapstruct.dto.OrderGetDto;
import com.endava.ticketsjavabackend.mapstruct.dto.OrderPostDto;
import com.endava.ticketsjavabackend.mapstruct.mappers.OrderMapper;
import com.endava.ticketsjavabackend.model.Customer;
import com.endava.ticketsjavabackend.model.Event;
import com.endava.ticketsjavabackend.model.Order;
import com.endava.ticketsjavabackend.model.TicketCategory;
import com.endava.ticketsjavabackend.repository.CustomerRepository;
import com.endava.ticketsjavabackend.repository.EventRepository;
import com.endava.ticketsjavabackend.repository.OrderRepository;
import com.endava.ticketsjavabackend.repository.TicketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final TicketCategoryRepository ticketCategoryRepository;
    private final EventRepository eventRepository;

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CustomerRepository customerRepository, TicketCategoryRepository ticketCategoryRepository, EventRepository eventRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<OrderGetDto> findOrdersByCustomerId(Integer customerId) {
        return orderMapper.ordersToOrderGetDtos(orderRepository.findOrdersByCustomer_Id(customerId));
    }

    @Override
    public OrderGetDto saveOrder(OrderPostDto order, Integer customerId) {
        if (order.getNumberOfTickets() <= 0) {
            throw new InvalidNumberOfTicketsException(order.getNumberOfTickets());
        }

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new InvalidIdException(customerId, "Customer");
        }

        Optional<TicketCategory> ticketCategory = ticketCategoryRepository.findById(order.getTicketCategoryId());
        if (ticketCategory.isEmpty()) {
            throw new InvalidIdException(order.getTicketCategoryId(), "TicketCategory");
        }

        Optional<Event> event = eventRepository.findById(order.getEventId());
        if (event.isEmpty()) {
            throw new InvalidIdException(order.getEventId(), "Event");
        }

        if (!ticketCategory.get().getEvent().getId().equals(event.get().getId())) {
            throw new InvalidTicketCategoryException(order.getTicketCategoryId(), order.getEventId());
        }

        if (order.getNumberOfTickets() > event.get().getAvailableSeats()) {
            throw new UnavailableSeatsException(order.getNumberOfTickets(), event.get().getAvailableSeats(), event.get().getId());
        }

        Order convertedOrder = orderMapper.orderPostDtoToOrder(order);
        convertedOrder.setCustomer(customer.get());
        convertedOrder.setTotalPrice(convertedOrder.getTicketCategory().getPrice() * convertedOrder.getNumberOfTickets());

        Order savedOrder = orderRepository.save(convertedOrder);
        eventRepository.refresh(event.get());

        return orderMapper.orderToOrderGetDto(savedOrder);
    }
}
