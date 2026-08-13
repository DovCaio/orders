package com.orders.demo.application.port.input;

import com.orders.demo.domain.model.Product;

public interface CreateProductUseCase {

    Product execute(CreateProductCommand command);

}
