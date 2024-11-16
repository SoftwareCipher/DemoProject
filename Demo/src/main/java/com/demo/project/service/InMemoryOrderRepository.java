package demo.project.service;

import demo.project.model.Order;
import demo.project.repo.OrderRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOrderRepository implements OrderRepository {
    private Map<Integer, Order> orders = new HashMap<>();

    public InMemoryOrderRepository() {
        orders.put(1, new Order());
        orders.put(2, new Order());
    }

    @Override
    public Order findById(int id) {
        return orders.get(id);
    }
}
