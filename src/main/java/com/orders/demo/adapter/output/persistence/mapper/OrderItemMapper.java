package com.orders.demo.adapter.output.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.orders.demo.adapter.output.persistence.entity.OrderItemEntity;
import com.orders.demo.domain.model.OrderItem;

@Component
public class OrderItemMapper {

        final private ProductMapper productMapper;

        OrderItemMapper(ProductMapper productMapper) {
                this.productMapper = productMapper;

        }

        public List<OrderItemEntity> fromDomain(List<OrderItem> items) {
                return items.stream()
                                .map(item -> new OrderItemEntity(item.getId(),
                                                productMapper.fromDomain(item.getProduct()),
                                                item.getUnitPrice(),
                                                item.getQuantity()))
                                .toList();
        }

        public List<OrderItem> toDomain(List<OrderItemEntity> items) {
                return items.stream()
                                .map(item -> new OrderItem(item.getId(),
                                                productMapper.toDomain(item.getProduct()),
                                                item.getUnitPrice(),
                                                item.getQuantity()))
                                .toList();
        }

}
