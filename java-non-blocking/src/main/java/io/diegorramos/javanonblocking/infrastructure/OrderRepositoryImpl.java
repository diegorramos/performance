package io.diegorramos.javanonblocking.infrastructure;

import io.diegorramos.javanonblocking.domain.OrderRepository;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.relational.core.query.Criteria.where;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final R2dbcEntityTemplate template;

    public OrderRepositoryImpl(R2dbcEntityTemplate template) {
        this.template = template;
    }
    
    public Flux<Order> list() {
        return template
                .select(Order.class)
                .from("orders")
                .all();
    }
    
    public Mono<Order> save(Order order) {
        return template.insert(order);
    }
    
    public Mono<Order> getById(String id) {
        return template
                .select(Order.class)
                .from("orders")
                .matching(Query.query(where("id").is(id)))
                .one();
    }
}
