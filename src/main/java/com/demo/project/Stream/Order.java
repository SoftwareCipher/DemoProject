package com.demo.project.Stream;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {
    private Long orderId;
    private List<Product> products;
    private String customerName;
    private String status; // "Pending", "Completed", "Cancelled"
    private LocalDate orderDate;

    public Order(Long orderId, List<Product> products,
                 String customerName, String status, LocalDate orderDate) {
        this.orderId = orderId;
        this.products = products;
        this.customerName = customerName;
        this.status = status;
        this.orderDate = orderDate;
    }
}
