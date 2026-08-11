package com.orders.demo.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orders.demo.application.port.input.CreateOrderCommand;
import com.orders.demo.application.port.input.CreateOrderItemCommand;
import com.orders.demo.application.port.input.CreateOrderUseCase;
import com.orders.demo.application.port.output.OrderRepository;
import com.orders.demo.application.port.output.ProductRepository;
import com.orders.demo.domain.model.Order;
import com.orders.demo.domain.model.OrderItem;
import com.orders.demo.domain.model.Product;

@Service
public class CreateOrderService implements CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public CreateOrderService(
            OrderRepository orderRepository,
            ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order execute(CreateOrderCommand command) {
        List<OrderItem> items = command.items()
                .stream()
                .map(this::createOrderItem)
                .toList();

        Order order = Order.create(items);

        return orderRepository.save(order);
    }

    private OrderItem createOrderItem(
            CreateOrderItemCommand command) {
        Product product = productRepository
                .findById(command.productId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Product not found: " + command.productId()));

        return new OrderItem(
                null,
                product,
                product.getPrice(),
                command.quantity());
    }

}
