package io.diegorramos.javablocking.infrastructure;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomOrderRepository {
    
    Order getById(String id);
}
