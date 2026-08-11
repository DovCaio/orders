package com.orders.demo.adapter.input.web.dto;

import java.util.List;

public record CreateOrderCommandResponse(
        List<CreateOrderItemResponse> items) {

}
