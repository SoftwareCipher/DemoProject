package demo.project.repo;

import demo.project.model.Order;

public interface OrderRepository {
    Order findById(int id);
}
