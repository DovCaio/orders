package com.orders.demo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.orders.demo.domain.model.Product;

public class ProductTest {

    @Test
    void shouldCreatAProduct() {
        Product product = Product.create("Keyboard", new BigDecimal(100));

        assertEquals("Keyboard", product.getName());
        assertEquals(new BigDecimal(100), product.getPrice());
    }

    @Test
    void shouldNotCreateAProductWithEmptyName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Product.create("", new BigDecimal(100)));
    }

    @Test
    void shouldNotCreateAProductWithNullName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Product.create(null, new BigDecimal(100)));
    }

    @Test
    void shouldNotCreateAProductWithNullPrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Product.create("Keyboard", null));
    }

    @Test
    void shouldNotCreateAProductWithNegativePrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Product.create("Keyboard", new BigDecimal(-1)));
    }

    @Test
    void shouldNotCreateAProductWithPriceEqualsToZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Product.create("Keyboard", new BigDecimal(0)));
    }

}
