package com.orders.demo.adapter.input.web.mapper;

import org.springframework.stereotype.Component;

import com.orders.demo.adapter.input.web.dto.product.CreateProductRequest;
import com.orders.demo.adapter.input.web.dto.product.CreateProductResponse;
import com.orders.demo.application.port.input.CreateProductCommand;
import com.orders.demo.domain.model.Product;

@Component
public class ProductRequestMapper {

    public CreateProductCommand toCommand(CreateProductRequest request) {

        return new CreateProductCommand(
                request.name(),
                request.price());

    }

    public CreateProductResponse toResponse(Product product) {
        return new CreateProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice());
    }

}
