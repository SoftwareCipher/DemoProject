package com.demo.project.Stream;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

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
    void testExistsProductWithName(){
        assertTrue(testStreamProduct.existsProductWithName("Gaming Console"));
    }

    @Test
    void testGetAllProductsSortedByName(){
        List<Product> list = new ArrayList<>(5);
        list.add(products.get(0));
        list.add(products.get(1));
        list.add(products.get(2));
        list.add(products.get(3));
        list.add(products.get(4));
        list.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        assertEquals(list, testStreamProduct.getAllProductsSortedByName());
    }

    @Test
    void testGroupProductsByReleaseYear(){
        Map<Integer, List<Product>> map = new HashMap<>(3);
        map.put(2021, List.of(products.get(0), products.get(2)));
        map.put(2020, List.of(products.get(1), products.get(4)));
        map.put(2019, List.of(products.get(3)));

        assertEquals(map, testStreamProduct.groupProductsByReleaseYear());
    }

    @Test
    void testGetAveragePriceInCategory(){
        double avgPrice = 833.32;
        double actual = Math.round(testStreamProduct.getAveragePriceInCategory("Electronics") * 100.0) / 100.0;
        assertEquals(avgPrice, actual);
    }

    @Test
    void testFindProductsAboveRating(){
        List<Product> products1 = new ArrayList<>(2);
        products1.add(products.get(0));
        products1.add(products.get(1));

        assertEquals(products1, testStreamProduct.findProductsAboveRating(4.6));
    }

    @Test
    void testGetProductsReleasedInLastNYears(){
        List<Product> products1 = new ArrayList<>(2);
        products1.add(products.get(0));
        products1.add(products.get(2));

        assertEquals(products1,testStreamProduct.getProductsReleasedInLastNYears(2021));
    }

    @Test
    void testGetMostExpensiveProductByCategory(){
        Map<String, Optional<Product>> map = new HashMap<>(3);
        map.put("Electronics", Optional.of(products.get(1)));
        map.put("Accessories", Optional.of(products.get(2)));
        map.put("Home Appliances", Optional.of(products.get(3)));

        assertEquals(map, testStreamProduct.getMostExpensiveProductByCategory());
    }

    @Test
    void testGetTotalBalance(){
        BigDecimal totalBalance = BigDecimal.valueOf(2749.95);

        assertEquals(totalBalance, testStreamProduct.getTotalBalance());
    }

    @Test
    void testGetProductsWithPriceAbove(){
        List<Product> products1 = new ArrayList<>(2);
        products1.add(products.get(0));
        products1.add(products.get(1));

        assertEquals(products1, testStreamProduct.getProductsWithPriceAbove(BigDecimal.valueOf(700)));
    }

    @Test
    void testGetCategorySummaries(){
        Map<String, CategorySummary> map = new HashMap<>(3);
        map.put("Electronics", new CategorySummary(3L, BigDecimal.valueOf(2499.97)));
        map.put("Accessories", new CategorySummary(1L, BigDecimal.valueOf(199.99)));
        map.put("Home Appliances", new CategorySummary(1L, BigDecimal.valueOf(49.99)));

        assertEquals(map, testStreamProduct.getCategorySummaries());
    }

    @Test
    void testGetProductsGroupedByCategorySortedByReleaseDate(){
        Map<String, List<Product>> map = new HashMap<>(3);
        map.put("Electronics", List.of(products.get(1), products.get(4), products.get(0)));
        map.put("Accessories", List.of(products.get(2)));
        map.put("Home Appliances", List.of(products.get(3)));

        assertEquals(map, testStreamProduct.getProductsGroupedByCategorySortedByReleaseDate());
    }

    @Test
    void testGetAveragePriceByCategoryAbove(){
        Map<String, Double> map = new HashMap<>(2);
        map.put("Accessories", 199.99);
        map.put("Electronics", 833.32);

        assertEquals(map, testStreamProduct.getAveragePriceByCategoryAbove(BigDecimal.valueOf(100)));
    }

    @Test
    void testGetCategoryWithHighestTotalPrice(){
        Optional<String> product = Optional.of("Electronics");

        assertEquals(product, testStreamProduct.getCategoryWithHighestTotalPrice());
    }
}