package com.orders.demo.adapter.input.web.dto;

import java.util.List;

public record CreateOrderResponse(
                List<CreateOrderItemResponse> items) {

}
