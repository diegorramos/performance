package io.diegorramos.javanonblocking.domain;

import io.diegorramos.javanonblocking.infrastructure.Order;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OrderRepository {
    
    Flux<Order> list();
    Mono<Order> save(Order order);
    Mono<Order> getById(String id);
}
