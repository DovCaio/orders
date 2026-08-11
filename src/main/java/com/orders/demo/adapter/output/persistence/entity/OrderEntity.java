package com.orders.demo.adapter.output.persistence.entity;

import java.math.BigDecimal;
import java.util.List;

import com.orders.demo.domain.model.OrderItem;
import com.orders.demo.domain.model.Status;

public class OrderEntity {

    private Long id;
    private List<OrderItem> items;
    private BigDecimal total;
    private Status status;

    protected OrderEntity() {

    }

    public OrderEntity(Long id, List<OrderItem> items, BigDecimal total, Status status) {
        this.id = id;
        this.items = items;
        this.total = total;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Status getStatus() {
        return status;
    }

}
