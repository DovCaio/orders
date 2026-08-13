package com.orders.demo.application.service;

import org.springframework.stereotype.Service;

import com.orders.demo.application.port.input.CreateProductCommand;
import com.orders.demo.application.port.input.CreateProductUseCase;
import com.orders.demo.application.port.output.ProductRepository;
import com.orders.demo.domain.model.Product;

@Service
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public Product execute(CreateProductCommand command) {
        Product product = new Product(command.name(), command.price());
        return productRepository.save(product);
    }

}
