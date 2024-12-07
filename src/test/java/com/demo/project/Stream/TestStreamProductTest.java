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

    @Test
    void testGetTotalPriceByCategory(){
        Map<String, BigDecimal> map = new HashMap<>(3);
        map.put("Electronics", products.get(0).getPrice()
                .add(products.get(1).getPrice()
                .add(products.get(4).getPrice())));
        map.put("Accessories", products.get(2).getPrice());
        map.put("Home Appliances", products.get(3).getPrice());

        assertEquals(map, testStreamProduct.getTotalPriceByCategory());
    }

    @Test
    void testFindCheapestProduct(){
        Optional<Product> product = Optional.of(products.get(3));

        assertEquals(product, testStreamProduct.findCheapestProduct());
    }

    @Test
    void testCountProductsReleasedBefore(){
        assertEquals(2, testStreamProduct.countProductsReleasedBefore(
                LocalDate.of(2020, 7, 1)));
    }

    @Test
    void testGetProductsInPriceRange(){
        List<Product> products1 = new ArrayList<>(3);
        products1.add(products.get(2));
        products1.add(products.get(3));
        products1.add(products.get(4));

        assertEquals(products1, testStreamProduct.getProductsInPriceRange(
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(700))
        );
    }

    @Test
    void testPartitionProductsByRating(){
        Map<Boolean, List<Product>> map = new HashMap<>(3);
        map.put(Boolean.TRUE, List.of(products.get(0), products.get(1)));
        map.put(Boolean.FALSE, List.of(products.get(2), products.get(3), products.get(4)));

        assertEquals(map, testStreamProduct.partitionProductsByRating(4.6));
    }

    @Test
    void testGetAllCategories(){
        Set<String> strings = new HashSet<>(3);
        strings.add(products.get(0).getCategory());
        strings.add(products.get(2).getCategory());
        strings.add(products.get(3).getCategory());

        assertEquals(strings, testStreamProduct.getAllCategories());
    }

    @Test
    void testGetRatingStatistics(){
        DoubleSummaryStatistics stats = testStreamProduct.getRatingStatistics();

        assertEquals(5, stats.getCount());
        assertEquals(4.8, stats.getMax());
        assertEquals(4.2, stats.getMin());
        assertEquals(4.56, stats.getAverage(), 0.01);
        assertEquals(22.8, stats.getSum(), 0.01);

        assertEquals(stats, testStreamProduct.getRatingStatistics());
    }
}