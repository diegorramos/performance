package io.diegorramos.javablocking.infrastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "order_id")
    private String orderId;
    
    @Column(name = "description")
    private String description;
    
    public String getId() {
        return id;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Order() {}
}
