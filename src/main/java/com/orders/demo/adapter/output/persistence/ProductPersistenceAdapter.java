package com.orders.demo.adapter.output.persistence;

import java.util.Optional;

import com.orders.demo.adapter.output.persistence.entity.ProductEntity;
import com.orders.demo.adapter.output.persistence.repository.JpaProductRepository;
import com.orders.demo.application.port.output.ProductRepository;
import com.orders.demo.domain.model.Product;

public class ProductPersistenceAdapter implements ProductRepository {

    private final JpaProductRepository repository;

    public ProductPersistenceAdapter(JpaProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> findById(Long id) {

        return repository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = fromDomain(product);
        ProductEntity saved = repository.save(entity);

        return toDomain(saved);
    }

    private ProductEntity fromDomain(Product product) {
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getPrice());
    }

    private Product toDomain(ProductEntity entity) {

        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getPrice());
    }

}
