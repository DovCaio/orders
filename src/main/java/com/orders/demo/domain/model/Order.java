package com.orders.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private List<OrderItem> items;
    private BigDecimal total;
    private Status status;

    public void pay() {
        if (status == Status.CANCELLED) {
            throw new IllegalStateException(
                    "A cancelled order cannot be paid");
        }

        if (status == Status.PAID) {
            throw new IllegalStateException(
                    "Order is already paid");
        }

        status = Status.PAID;
    }

    private static BigDecimal calculateTotal(List<OrderItem> items) {
        return items.stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Order create(List<OrderItem> items) {

        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException(
                    "Order must contain at least one item");
        }

        Order order = new Order();
        order.items = items;
        order.status = Status.PENDING;
        order.total = calculateTotal(items);

        return order;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Status getStatus() {
        return status;
    }

}