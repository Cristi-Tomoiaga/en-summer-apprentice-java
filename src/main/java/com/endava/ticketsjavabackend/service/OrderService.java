package com.endava.ticketsjavabackend.service;

import com.endava.ticketsjavabackend.mapstruct.dto.OrderGetDto;
import com.endava.ticketsjavabackend.mapstruct.dto.OrderPostDto;

import java.util.List;

public interface OrderService {
    List<OrderGetDto> findOrdersByCustomerId(Integer customerId);
    OrderGetDto saveOrder(OrderPostDto order, Integer customerId);
}
