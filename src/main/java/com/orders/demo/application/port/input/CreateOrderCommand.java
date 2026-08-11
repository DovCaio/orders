package com.orders.demo.application.port.input;

import java.util.List;

public record CreateOrderCommand(
        List<CreateOrderItemCommand> items) {
}