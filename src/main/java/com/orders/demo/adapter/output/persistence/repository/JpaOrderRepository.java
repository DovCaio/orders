package com.orders.demo.adapter.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.demo.adapter.output.persistence.entity.OrderEntity;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {

}
