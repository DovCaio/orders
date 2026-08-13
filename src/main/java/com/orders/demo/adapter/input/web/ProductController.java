package com.orders.demo.adapter.input.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.demo.adapter.input.web.dto.product.CreateProductRequest;
import com.orders.demo.adapter.input.web.dto.product.CreateProductResponse;
import com.orders.demo.adapter.input.web.mapper.ProductRequestMapper;
import com.orders.demo.application.port.input.CreateProductCommand;
import com.orders.demo.application.port.input.CreateProductUseCase;
import com.orders.demo.domain.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ProductRequestMapper mapper;

    ProductController(CreateProductUseCase createProductUseCase, ProductRequestMapper mapper) {
        this.createProductUseCase = createProductUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(
            @RequestBody CreateProductRequest request) {
        CreateProductCommand command = mapper.toCommand(request);

        Product order = createProductUseCase.execute(command);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(order));
    }

}
