package com.orders.demo.application.port.input;

public record CreateOrderItemCommand(
        Long productId,
        int quantity) {
}