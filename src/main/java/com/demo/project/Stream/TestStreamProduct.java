package com.demo.project.Stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
                .map(Product::getName)
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

    public Optional<Product> findOldestProduct() {
        return products.stream()
                .min(Comparator.comparing(Product::getReleaseDate));
    }

    public Map<String, BigDecimal> getTotalPriceByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Product::getPrice,
                                BigDecimal::add
                        )
                ));
    }

    public Optional<Product> findCheapestProduct() {
        return products.stream()
                .min(Comparator.comparing(Product::getPrice));
    }

    public long countProductsReleasedBefore(LocalDate date) {
        return products.stream()
                .filter(product -> product.getReleaseDate().isBefore(date))
                .count();
    }

    public List<Product> getProductsInPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice().compareTo(minPrice) > 0)
                .filter(product -> product.getPrice().compareTo(maxPrice) < 0)
                .toList();
    }

    public Map<Boolean, List<Product>> partitionProductsByRating(Double ratingThreshold) {
        return products.stream()
                .collect(
                        Collectors.partitioningBy(product -> product.getRating() > ratingThreshold));
    }

    public Set<String> getAllCategories() {
        return products.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
    }

    public boolean existsProductWithName(String name) {
        return products.stream()
                .anyMatch(product -> product.getName().contains(name));
    }

    public List<Product> getAllProductsSortedByName() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .toList();
    }

    public Map<Integer, List<Product>> groupProductsByReleaseYear() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        product -> product.getReleaseDate().getYear()
                ));
    }

    public double getAveragePriceInCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .map(Product::getPrice)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(0.0);
    }

    public List<Product> findProductsAboveRating(double ratingThreshold) {
        return products.stream()
                .filter(product -> product.getRating() > ratingThreshold)
                .toList();
    }

    public List<Product> getProductsReleasedInLastNYears(int years) {
        return products.stream()
                .filter(product -> product.getReleaseDate().getYear() == years)
                .toList();
    }

    public Map<String, Optional<Product>> getMostExpensiveProductByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))
                ));
    }

    public BigDecimal getTotalBalance() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Product> getProductsWithPriceAbove(BigDecimal priceThreshold) {
        return products.stream()
                .filter(product -> product.getPrice().compareTo(priceThreshold) > 0)
                .toList();
    }

    public Map<String, CategorySummary> getCategorySummaries() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                products1 -> new CategorySummary(
                                        products1.size(),
                                        products1.stream()
                                                .map(Product::getPrice)
                                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                                )
                        )
                ));
    }

    public Map<String, List<Product>> getProductsGroupedByCategorySortedByReleaseDate() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getReleaseDate))
                .collect(
                        Collectors.groupingBy(Product::getCategory));
    }

    public Map<String, Double> getAveragePriceByCategoryAbove(BigDecimal priceThreshold) {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(product -> product.getPrice().doubleValue())
                )).entrySet().stream()
                .filter(entry -> BigDecimal.valueOf(entry.getValue()).compareTo(priceThreshold) > 0)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> BigDecimal.valueOf(entry.getValue())
                                .setScale(2, RoundingMode.HALF_UP)
                                .doubleValue()
                ));
    }

    public Optional<String> getCategoryWithHighestTotalPrice() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.reducing(BigDecimal.ZERO, Product::getPrice, BigDecimal::add)
                )).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
