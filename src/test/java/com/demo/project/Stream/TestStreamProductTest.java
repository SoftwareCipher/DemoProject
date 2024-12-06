package com.demo.project.Stream;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.Optional;

import static com.demo.project.Stream.TestStreamProduct.products;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestStreamProductTest {
    private TestStreamProduct testStreamProduct = new TestStreamProduct();

    @Test
    void testFindMostExpensiveProduct(){
        Optional<Product> product = Optional.of(products.get(1));

        assertEquals(product, testStreamProduct.findMostExpensiveProduct());
    }


}