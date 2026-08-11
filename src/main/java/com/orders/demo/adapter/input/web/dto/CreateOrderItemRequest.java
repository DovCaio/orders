package com.orders.demo.adapter.input.web.dto;

public record CreateOrderItemRequest(
        Long productId,
        int quantity) {
}
