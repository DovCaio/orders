package com.orders.demo.adapter.output.persistence.entity;

import java.math.BigDecimal;
import java.util.List;

import com.orders.demo.domain.model.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private Long id;
    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> items;
    private BigDecimal total;
    private Status status;

    protected OrderEntity() {

    }

    public OrderEntity(Long id, List<OrderItemEntity> items, BigDecimal total, Status status) {
        this.id = id;
        this.items = items;
        this.total = total;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Status getStatus() {
        return status;
    }

}
