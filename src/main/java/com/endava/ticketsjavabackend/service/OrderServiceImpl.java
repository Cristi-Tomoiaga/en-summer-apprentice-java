package com.endava.ticketsjavabackend.service;

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
            return null;
        }

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            return null;
        }

        Optional<TicketCategory> ticketCategory = ticketCategoryRepository.findById(order.getTicketCategoryId());
        if (ticketCategory.isEmpty()) {
            return null;
        }

        Optional<Event> event = eventRepository.findById(order.getEventId());
        if (event.isEmpty()) {
            return null;
        }

        if (!ticketCategory.get().getEvent().getId().equals(event.get().getId())) {
            return null;
        }

        Order convertedOrder = orderMapper.orderPostDtoToOrder(order);
        convertedOrder.setCustomer(customer.get());
        convertedOrder.setTotalPrice(convertedOrder.getTicketCategory().getPrice() * convertedOrder.getNumberOfTickets());
        return orderMapper.orderToOrderGetDto(orderRepository.save(convertedOrder));
    }
}
