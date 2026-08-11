package com.orders.demo.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderItem {

    private Long id;
    private Product product;
    private BigDecimal unitPrice;
    private Integer quantity;

    public BigDecimal getSubtotal() {
        return unitPrice.multiply(
                BigDecimal.valueOf(quantity));
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

}