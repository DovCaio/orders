package com.orders.demo.adapter.input.web.dto.order;

import java.util.List;

public record CreateOrderResponse(
        List<CreateOrderItemResponse> items) {

}
