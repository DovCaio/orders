package com.orders.demo.application.port.input;

import java.math.BigDecimal;

public record CreateProductCommand(
        String name,
        BigDecimal price

) {

}
