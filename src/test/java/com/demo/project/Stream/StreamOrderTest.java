package com.demo.project.Stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static com.demo.project.Stream.StreamOrder.orders;
import static org.junit.jupiter.api.Assertions.*;

class StreamOrderTest {

    private final StreamOrder streamOrder = new StreamOrder();

    @Test
    void testGetCompletedOrders() {
        List<Order> list = new ArrayList<>();
        list.add(orders.get(0));
        list.add(orders.get(3));

        assertEquals(list, streamOrder.getCompletedOrders());
    }

    @Test
    void testCountProductsInPendingOrders(){
        List<Order> orders =List.of(StreamOrder.orders.get(1), StreamOrder.orders.get(4));

        assertEquals(orders.size(), streamOrder.countProductsInPendingOrders());
        assertEquals("Pending", orders.getFirst().getStatus());
    }

    @Test
    void testGetOrderWithHighestTotalValue(){
        Optional<Order> order = Optional.of(orders.get(2));

        assertEquals(order, streamOrder.getOrderWithHighestTotalValue());
    }

    @Test
    void testGetTop3MostExpensiveProducts(){
        List<Product> products = new ArrayList<>();
        products.add(StreamOrder.orders.get(2).getProducts().getFirst());
        products.add(StreamOrder.orders.get(0).getProducts().getFirst());
        products.add(StreamOrder.orders.get(3).getProducts().getFirst());


        assertEquals(products, streamOrder.getTop3MostExpensiveProducts());
    }

    @Test
    void testGetOrdersByStatus(){
        List<Order> orders1 = new ArrayList<>();
        orders1.add(orders.get(0));
        orders1.add(orders.get(3));

        assertEquals(orders1, streamOrder.getOrdersByStatus("Completed"));
    }

    @Test
    void testGetAverageRatingByCustomerName(){
        assertEquals(OptionalDouble.of(4.6), streamOrder.getAverageRatingByCustomerName("Alice Johnson"));
    }

    @Test
    void testGetAverageRatingByCustomerName_2(){
        assertEquals(OptionalDouble.of(4.55), streamOrder.getAverageRatingByCustomerName("Daisy Miller"));
    }
}