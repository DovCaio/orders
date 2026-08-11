package com.orders.demo.application.port.output;

import com.orders.demo.domain.model.Order;

public interface OrderRepository {

    Order save(Order order);

}