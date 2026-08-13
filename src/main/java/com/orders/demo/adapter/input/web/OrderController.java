package com.orders.demo.adapter.input.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.demo.adapter.input.web.dto.order.CreateOrderRequest;
import com.orders.demo.adapter.input.web.dto.order.CreateOrderResponse;
import com.orders.demo.adapter.input.web.mapper.OrderRequestMapper;
import com.orders.demo.application.port.input.CreateOrderCommand;
import com.orders.demo.application.port.input.CreateOrderUseCase;
import com.orders.demo.domain.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final OrderRequestMapper mapper;

    public OrderController(CreateOrderUseCase createOrderUseCase, OrderRequestMapper mapper) {
        this.createOrderUseCase = createOrderUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> create(
            @RequestBody CreateOrderRequest request) {
        CreateOrderCommand command = mapper.toCommand(request);

        Order order = createOrderUseCase.execute(command);

        return ResponseEntity.ok(mapper.toResponse(order));
    }

}
