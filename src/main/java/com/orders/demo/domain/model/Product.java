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

}