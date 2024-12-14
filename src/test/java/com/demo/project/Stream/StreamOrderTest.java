package com.demo.project.Stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.demo.project.Stream.StreamOrder.orders;
import static org.junit.jupiter.api.Assertions.*;

class StreamOrderTest {

    private StreamOrder streamOrder = new StreamOrder();

    @Test
    void testGetCompletedOrders() {
        List<Order> list = new ArrayList<>();
        list.add(orders.get(0));
        list.add(orders.get(3));

        assertEquals(list, streamOrder.getCompletedOrders());
    }
}