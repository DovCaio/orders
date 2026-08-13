package com.orders.demo.adapter.input.web.dto.product;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        BigDecimal price) {

}
