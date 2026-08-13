package com.orders.demo.adapter.output.persistence;

import org.springframework.stereotype.Component;

import com.orders.demo.adapter.output.persistence.entity.OrderEntity;
import com.orders.demo.adapter.output.persistence.mapper.OrderMapper;
import com.orders.demo.adapter.output.persistence.repository.JpaOrderRepository;
import com.orders.demo.application.port.output.OrderRepository;
import com.orders.demo.domain.model.Order;

@Component
public class OrderPersistenceAdapter implements OrderRepository {

    private final JpaOrderRepository repository;
    private final OrderMapper mapper;

    OrderPersistenceAdapter(JpaOrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = mapper.fromDomain(order);
        OrderEntity saved = repository.save(entity);

        return mapper.toDomain(saved);
    }

}
