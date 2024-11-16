package demo.project.service;

import demo.project.model.Order;
import demo.project.repo.OrderRepository;

public class ServiceOrder {
    private final OrderRepository orderRepository;

    public ServiceOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findOrderById(int id) {
        return orderRepository.findById(id);
    }
}
