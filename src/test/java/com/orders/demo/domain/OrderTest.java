package com.orders.demo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.orders.demo.domain.model.Order;
import com.orders.demo.domain.model.OrderItem;
import com.orders.demo.domain.model.Product;
import com.orders.demo.domain.model.Status;

public class OrderTest {
    @Test
    void shouldCreateOrder() {
        Product product = new Product(
                1L,
                "Keyboard",
                new BigDecimal("100.00"));

        OrderItem item = new OrderItem(
                null,
                product,
                product.getPrice(),
                2);

        Order order = Order.create(List.of(item));

        assertEquals(Status.PENDING, order.getStatus());
        assertEquals(1, order.getItems().size());
    }

    @Test
    void shouldCalculateOrderTotal() {
        Product product = new Product(
                1L,
                "Keyboard",
                new BigDecimal("100.00"));

        OrderItem item = new OrderItem(
                null,
                product,
                product.getPrice(),
                2);

        Order order = Order.create(List.of(item));

        assertEquals(
                new BigDecimal("200.00"),
                order.getTotal());
    }

    @Test
    void shouldPayOrder() {
        Product product = new Product(
                1L,
                "Keyboard",
                new BigDecimal("100.00"));

        OrderItem item = new OrderItem(
                null,
                product,
                product.getPrice(),
                1);

        Order order = Order.create(List.of(item));

        order.pay();

        assertEquals(Status.PAID, order.getStatus());
    }

    @Test
    void shouldNotPayCancelledOrder() {
        Product product = new Product(
                1L,
                "Keyboard",
                new BigDecimal("100.00"));

        OrderItem item = new OrderItem(
                null,
                product,
                product.getPrice(),
                1);

        Order order = Order.create(List.of(item));

        order.cancel();

        assertThrows(
                IllegalStateException.class,
                order::pay);
    }

    @Test
    void shouldNotCancellPaidedOrder() {
        Product product = new Product(
                1L,
                "Keyboard",
                new BigDecimal("100.00"));

        OrderItem item = new OrderItem(
                null,
                product,
                product.getPrice(),
                1);

        Order order = Order.create(List.of(item));

        order.pay();

        assertThrows(
                IllegalStateException.class,
                order::cancel);
    }
}
