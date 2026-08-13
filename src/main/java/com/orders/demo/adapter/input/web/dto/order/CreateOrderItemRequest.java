package com.orders.demo.adapter.input.web.dto.order;

public record CreateOrderItemRequest(
        Long productId,
        int quantity) {
}
