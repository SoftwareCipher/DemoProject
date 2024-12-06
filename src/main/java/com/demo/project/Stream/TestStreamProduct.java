package com.demo.project.Stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TestStreamProduct {
    public static List<Product> products = Arrays.asList(
            new Product(1L, "Smartphone X", "Electronics", BigDecimal.valueOf(799.99),
                    4.7, LocalDate.parse("2021-09-10")),
            new Product(2L, "Laptop Pro", "Electronics", BigDecimal.valueOf(1199.99),
                    4.8, LocalDate.parse("2020-06-15")),
            new Product(3L, "Wireless Headphones", "Accessories", BigDecimal.valueOf(199.99),
                    4.5, LocalDate.parse("2021-03-05")),
            new Product(4L, "Electric Kettle", "Home Appliances", BigDecimal.valueOf(49.99),
                    4.2, LocalDate.parse("2019-11-20")),
            new Product(5L, "Gaming Console", "Electronics", BigDecimal.valueOf(499.99),
                    4.6, LocalDate.parse("2020-11-12"))
    );

    public Optional<Product> findMostExpensiveProduct() {
        return products.stream()
                .max(Comparator.comparing(Product::getPrice));
    }

    public List<Product> getProductsByCategory(String category) {
        return products.stream()
                .filter(c -> c.getCategory().equals(category))
                .toList();
    }

    public Map<String, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory
                ));
    }

    public Double calculateAverageRating() {
        return products.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingDouble(Product::getRating),
                        avg -> Math.round(avg * 100) / 100.0));
    }

    //Найти топ N продуктов с самым высоким рейтингом
    public List<Product> findTopRatedProducts(int n) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getRating).reversed())
                .limit(n)
                .toList();
    }

    public Map<Boolean, List<Product>> partitionProductsByPrice(BigDecimal priceThreshold) {
        return products.stream()
                .collect(Collectors.partitioningBy(
                        product -> product.getPrice().compareTo(priceThreshold) > 0
                ));
    }

    public List<String> getProductNamesReleasedAfter(LocalDate date) {
        return products.stream()
                .filter(product -> product.getReleaseDate().isAfter(date))
                .map(Objects::toString)
                .toList();
    }

    public boolean areAllProductsInCategoryRatedAbove(String category, Double ratingThreshold) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .anyMatch(rating -> rating.getRating().compareTo(ratingThreshold) > 0);
    }

    public Map<String, Long> countProductsInEachCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.counting()
                ));
    }

    public Optional<Product> findOldestProduct(){
        return products.stream()
                .min(Comparator.comparing(Product::getReleaseDate));
    }
}