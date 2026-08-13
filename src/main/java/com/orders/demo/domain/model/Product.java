package com.orders.demo.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;

    public static Product create(String name, BigDecimal price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                    "Product name must not be empty.");
        }

        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Product price must be greater than zero.");
        }

        return new Product(null, name, price);

    }

}