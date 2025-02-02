package com.demo.project.Stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class StreamOrder {
    public static List<Order> orders = Arrays.asList(

            new Order(1L, Arrays.asList(
                    new Product(1L, "Smartphone X", "Electronics",
                            BigDecimal.valueOf(799.99), 4.7, LocalDate.parse("2021-09-10")),
                    new Product(3L, "Wireless Headphones", "Accessories",
                            BigDecimal.valueOf(199.99), 4.5, LocalDate.parse("2021-03-05"))),
                    "Alice Johnson", "Completed", LocalDate.parse("2021-11-15")),

            new Order(2L, Arrays.asList(
                    new Product(4L, "Electric Kettle", "Home Appliances",
                            BigDecimal.valueOf(49.99), 4.2, LocalDate.parse("2019-11-20"))),
                    "Bob Smith", "Pending", LocalDate.parse("2023-09-25")),

            new Order(3L, Arrays.asList(
                    new Product(2L, "Laptop Pro", "Electronics",
                            BigDecimal.valueOf(1199.99), 4.8, LocalDate.parse("2020-06-15"))),
                    "Charlie Brown", "Cancelled", LocalDate.parse("2022-03-10")),

            new Order(4L, Arrays.asList(
                    new Product(5L, "Gaming Console", "Electronics",
                            BigDecimal.valueOf(499.99), 4.6, LocalDate.parse("2020-11-12")),
                    new Product(3L, "Wireless Headphones", "Accessories",
                            BigDecimal.valueOf(199.99), 4.5, LocalDate.parse("2021-03-05"))),
                    "Daisy Miller", "Completed", LocalDate.parse("2021-07-05")),

            new Order(6L, Arrays.asList(
                    new Product(4L, "Electric Kettle", "Home Appliances",
                            BigDecimal.valueOf(49.99), 4.2, LocalDate.parse("2019-11-20"))
            ), "Frank Wright", "Pending", LocalDate.parse("2023-08-15"))
    );

    public List<Order> getCompletedOrders(){
        return orders.stream()
                .filter(order -> order.getStatus().equals("Completed"))
                .toList();
    }

    public long countProductsInPendingOrders(){
        return orders.stream()
                .filter(order -> order.getStatus().equals("Pending")).count();
    }

    public Optional<Order> getOrderWithHighestTotalValue(){
        return orders.stream()
                .max(Comparator.comparing(order ->
                        order.getProducts().stream()
                                .map(Product::getPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ));
    }

    public List<Product> getTop3MostExpensiveProducts(){
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(3)
                .toList();
    }

    public List<Order> getOrdersByStatus(String status){
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .toList();
    }

    public OptionalDouble getAverageRatingByCustomerName(String customerName){
        return orders.stream()
                .filter(order -> order.getCustomerName().equals(customerName))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getRating)
                .average();
    }
}
