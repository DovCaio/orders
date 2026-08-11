package com.orders.demo.application.port.input;

import com.orders.demo.domain.model.Order;

public interface CreateOrderUseCase {

    Order execute(CreateOrderCommand command);

}