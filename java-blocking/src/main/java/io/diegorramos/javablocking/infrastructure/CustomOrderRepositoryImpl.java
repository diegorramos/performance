package io.diegorramos.javablocking.infrastructure;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomOrderRepositoryImpl implements CustomOrderRepository {
    
    private final JdbcTemplate jdbcTemplate;
    
    public CustomOrderRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Order getById(String id) {
        return jdbcTemplate.queryForObject("select * from orders where id = :id", Order.class, id);
    }
}
