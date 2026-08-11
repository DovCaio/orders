package com.orders.demo.adapter.output.persistence.mapper;

import org.springframework.stereotype.Component;

import com.orders.demo.adapter.output.persistence.entity.ProductEntity;
import com.orders.demo.domain.model.Product;

@Component
public class ProductMapper {

    ProductMapper() {

    }

    public ProductEntity fromDomain(Product product) {
        return new ProductEntity(product.getId(), product.getName(), product.getPrice());
    }

    public Product toDomain(ProductEntity product) {
        return new Product(product.getId(), product.getName(), product.getPrice());
    }
}
