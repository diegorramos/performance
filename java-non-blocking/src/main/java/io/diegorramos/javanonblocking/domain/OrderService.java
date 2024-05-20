package io.diegorramos.javanonblocking.domain;

import io.diegorramos.javanonblocking.infrastructure.Order;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    
    private final OrderRepository repository;
    
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    
    public Flux<Order> list() {
        return repository.list();
    }
    
    public Mono<Order> save(Order order) {
        return repository.save(order);
    }
    
    public Mono<Order> getById(String id) {
        return repository.getById(id);
    }
}
