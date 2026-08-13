package com.orders.demo.adapter.input.web.mapper;

import org.springframework.stereotype.Component;

import com.orders.demo.adapter.input.web.dto.order.CreateOrderItemResponse;
import com.orders.demo.adapter.input.web.dto.order.CreateOrderRequest;
import com.orders.demo.adapter.input.web.dto.order.CreateOrderResponse;
import com.orders.demo.application.port.input.CreateOrderCommand;
import com.orders.demo.application.port.input.CreateOrderItemCommand;
import com.orders.demo.domain.model.Order;

@Component
public class OrderRequestMapper {

        public CreateOrderCommand toCommand(CreateOrderRequest request) {
                return new CreateOrderCommand(
                                request.items()
                                                .stream()
                                                .map(item -> new CreateOrderItemCommand(
                                                                item.productId(),
                                                                item.quantity()))
                                                .toList());
        }

        public CreateOrderResponse toResponse(Order order) {
                return new CreateOrderResponse(
                                order.getItems()
                                                .stream()
                                                .map(item -> new CreateOrderItemResponse(
                                                                item.getProduct().getId(),
                                                                item.getQuantity()))
                                                .toList());
        }
}
