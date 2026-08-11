package com.orders.demo.adapter.output.persistence.entity;

import java.math.BigDecimal;

import com.orders.demo.domain.model.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_item")
public class OrderItemEntity {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")

    private OrderEntity orderEntity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private BigDecimal unitPrice;
    private Integer quantity;

    protected OrderItemEntity() {

    }

    public OrderItemEntity(Long id, ProductEntity product, BigDecimal unitPrice, Integer quantity) {
        this.id = id;
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
