package io.diegorramos.javanonblocking.application;

import io.diegorramos.javanonblocking.domain.OrderService;
import io.diegorramos.javanonblocking.infrastructure.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderHandler extends AbstractHandler {
    
    private final OrderService service;
    
    public OrderHandler(OrderService service) {
        this.service = service;
    }
    
    public Mono<ServerResponse> list(ServerRequest request) {
        return service
                .list()
                .collectList()
                .flatMap(order -> super.response(order, HttpStatus.OK));
    }
    
    public Mono<ServerResponse> create(ServerRequest request) {
        return request
                .bodyToMono(Order.class)
                .flatMap(service::save)
                .flatMap(result -> super.response(result, HttpStatus.CREATED));
    }
    
    public Mono<ServerResponse> getById(ServerRequest request) {
        return service
                .getById(request.pathVariable("id"))
                .flatMap(order -> super.response(order, HttpStatus.OK));
    }
}
