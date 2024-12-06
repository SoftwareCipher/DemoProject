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

    @Test
    void testGetProductsByCategory(){
        List<Product> list = new ArrayList<>();
        list.add(products.get(0));
        list.add(products.get(1));
        list.add(products.get(4));

        assertEquals(list, testStreamProduct.getProductsByCategory("Electronics"));
    }

    @Test
    void testGroupProductsByCategory(){
        Map<String, List<Product>> map = new HashMap<>(3);
        map.put("Electronics", List.of(products.get(0), products.get(1), products.get(4)));
        map.put("Accessories", List.of(products.get(2)));
        map.put("Home Appliances", List.of(products.get(3)));

        assertEquals(map, testStreamProduct.groupProductsByCategory());
    }

    @Test
    void testCalculateAverageRating(){
        Double averageRatingProduct = (products.get(0).getRating() + products.get(1).getRating() +
                products.get(2).getRating() + products.get(3).getRating() + products.get(4).getRating())
                / products.size();

        assertEquals(averageRatingProduct, testStreamProduct.calculateAverageRating());
    }
}