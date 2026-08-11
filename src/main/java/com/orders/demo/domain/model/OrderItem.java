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
}