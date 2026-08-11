package com.orders.demo.application.port.output;

import java.util.Optional;

import com.orders.demo.domain.model.Product;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

}
