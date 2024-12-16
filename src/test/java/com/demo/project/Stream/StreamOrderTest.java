package com.demo.project.Stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
}