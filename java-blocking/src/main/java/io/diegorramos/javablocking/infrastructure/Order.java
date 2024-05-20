package io.diegorramos.javablocking.infrastructure;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "orders")
public record Order(
        
        @Column("id")
        String id,
        
        @Column("order_id")
        String orderId,
        
        @Column("description")
        String description
) {}
