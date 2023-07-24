package com.endava.ticketsjavabackend.controller;

import com.endava.ticketsjavabackend.mapstruct.dto.OrderGetDto;
import com.endava.ticketsjavabackend.mapstruct.dto.OrderPostDto;
import com.endava.ticketsjavabackend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private static final Integer customerId = 3;
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderGetDto> getAllByCustomerId() {
        return orderService.findOrdersByCustomerId(customerId);
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody OrderPostDto order) {
        OrderGetDto result = orderService.saveOrder(order, customerId);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Map<String, OrderGetDto> resultBody = new HashMap<>();
        resultBody.put("order", result);
        return new ResponseEntity<>(resultBody, HttpStatus.CREATED);
    }
}
