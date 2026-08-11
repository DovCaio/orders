package com.orders.demo.adapter.output.persistence;

import com.orders.demo.adapter.output.persistence.entity.OrderEntity;
import com.orders.demo.adapter.output.persistence.repository.JpaOrderRepository;
import com.orders.demo.application.port.output.OrderRepository;
import com.orders.demo.domain.model.Order;

public class OrderPersistenceAdapter implements OrderRepository {

    private final JpaOrderRepository repository;

    OrderPersistenceAdapter(JpaOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = fromDomain(order);
        OrderEntity saved = repository.save(entity);

        return toDomain(saved);
    }

    private OrderEntity fromDomain(Order order) {
        return new OrderEntity(
                order.getId(),
                order.getItems(),
                order.getTotal(),
                order.getStatus());

    }

    private Order toDomain(OrderEntity order) {
        return new Order(
                order.getId(),
                order.getItems(),
                order.getTotal(),
                order.getStatus());

    }
}
