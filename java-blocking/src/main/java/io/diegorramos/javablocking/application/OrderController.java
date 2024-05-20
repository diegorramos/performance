package io.diegorramos.javablocking.application;

import io.diegorramos.javablocking.domain.OrderService;
import io.diegorramos.javablocking.infrastructure.Order;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
public class OrderController {
    
    private final OrderService service;
    
    public OrderController(OrderService service) {
        this.service = service;
    }
    
    @PostMapping("/")
    public Order save(@RequestBody Order order) {
        return service.save(order);
    }
    
    @GetMapping("/{id}")
    public Order getById(@PathVariable String id) {
        return service.getById(id);
    }
}
