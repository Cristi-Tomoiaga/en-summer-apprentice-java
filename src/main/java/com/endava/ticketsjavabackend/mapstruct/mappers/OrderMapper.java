package com.endava.ticketsjavabackend.mapstruct.mappers;

import com.endava.ticketsjavabackend.mapstruct.dto.OrderGetDto;
import com.endava.ticketsjavabackend.mapstruct.dto.OrderPostDto;
import com.endava.ticketsjavabackend.model.Order;
import com.endava.ticketsjavabackend.repository.TicketCategoryRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class OrderMapper {
    @Autowired
    protected TicketCategoryRepository ticketCategoryRepository;

    @Mapping(source = "orderedAt", target = "timestamp")
    @Mapping(source = "ticketCategory.event", target = "event")
    public abstract OrderGetDto orderToOrderGetDto(Order order);

    @Mapping(target = "ticketCategory", expression = "java( ticketCategoryRepository.findById(orderPostDto.getTicketCategoryId()).get() )")
    @Mapping(target = "orderedAt", expression = "java( java.time.LocalDateTime.now() )")
    @Mapping(target = "id", ignore = true)
    public abstract Order orderPostDtoToOrder(OrderPostDto orderPostDto);

    public abstract List<OrderGetDto> ordersToOrderGetDtos(List<Order> orders);
}
