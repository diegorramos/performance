package io.diegorramos.javanonblocking.infrastructure;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "orders")
public record Order(
        
        @Id
        @Column("id")
        String id,
        
        @Column("orderId")
        String orderId,
        
        @Column("description")
        String description
) {}
