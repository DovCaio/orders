package com.orders.demo.adapter.input.web.dto.product;

import java.math.BigDecimal;

public record CreateProductResponse(
        Long id,
        String name,
        BigDecimal price) {

}
