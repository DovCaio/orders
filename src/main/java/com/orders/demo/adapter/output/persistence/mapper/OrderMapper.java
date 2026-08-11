package com.orders.demo.adapter.output.persistence.mapper;

import org.springframework.stereotype.Component;

import com.orders.demo.adapter.output.persistence.entity.OrderEntity;
import com.orders.demo.domain.model.Order;

@Component
public class OrderMapper {

    final private OrderItemMapper orderItemMapper;

    OrderMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;

    }

    public OrderEntity fromDomain(Order order) {
        return new OrderEntity(
                order.getId(),
                orderItemMapper.fromDomain(order.getItems()),
                order.getTotal(),
                order.getStatus());

    }

    public Order toDomain(OrderEntity order) {
        return new Order(
                order.getId(),
                orderItemMapper.toDomain(order.getItems()),
                order.getTotal(),
                order.getStatus());

    }
}
