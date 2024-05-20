package io.diegorramos.javablocking.domain;

import io.diegorramos.javablocking.infrastructure.Order;
import io.diegorramos.javablocking.infrastructure.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    private final OrderRepository repository;
    
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    
    public Iterable<Order> listAll() {
        return repository.findAll();
    }
    
    public Order save(Order order) {
        return repository.save(order);
    }
    
    public Order getById(String id) {
        return repository.findById(id).get();
    }
}
