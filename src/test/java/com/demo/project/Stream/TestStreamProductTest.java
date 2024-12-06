package com.demo.project.Stream;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.Optional;

import static com.demo.project.Stream.TestStreamProduct.products;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testFindTopRatedProducts(){
        List<Product> prod = List.of(products.get(1), products.get(0), products.get(4));

        assertEquals(prod, testStreamProduct.findTopRatedProducts(3));
    }

    @Test
    void testPartitionProductsByPrice(){
        Map<Boolean, List<Product>> map = new HashMap<>(2);
        map.put(Boolean.TRUE, List.of(products.get(0), products.get(1)));
        map.put(Boolean.FALSE, List.of(products.get(2), products.get(3), products.get(4)));

        assertEquals(map, testStreamProduct.partitionProductsByPrice(BigDecimal.valueOf(500)));
    }

    @Test
    void testGetProductNamesReleasedAfter(){
        List<String> list = new ArrayList<>(3);
        list.add(String.valueOf(products.get(0)));
        list.add(String.valueOf(products.get(2)));
        list.add(String.valueOf(products.get(4)));

        testStreamProduct.getProductNamesReleasedAfter(LocalDate.of(2020, 10, 10));
    }

    @Test
    void testAreAllProductsInCategoryRatedAbove(){
        assertTrue(testStreamProduct.areAllProductsInCategoryRatedAbove("Electronics", 4.7));
    }

    @Test
    void testCountProductsInEachCategory(){
        Map<String, Long> map = new HashMap<>(3);
        map.put("Electronics", 3L);
        map.put("Accessories", 1L);
        map.put("Home Appliances", 1L);

        assertEquals(map, testStreamProduct.countProductsInEachCategory());
    }

    @Test
    void testFindOldestProduct(){
        Optional<Product> oldProduct = Optional.of(products.get(3));

        assertEquals(oldProduct, testStreamProduct.findOldestProduct());
    }
}