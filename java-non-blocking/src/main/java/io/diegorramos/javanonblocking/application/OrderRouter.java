package io.diegorramos.javanonblocking.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class OrderRouter {

    @Bean
    public RouterFunction<ServerResponse> route(OrderHandler handler) {
        return RouterFunctions
                .route(POST("/orders").and(accept(MediaType.APPLICATION_JSON)), handler::create)
                .andRoute(GET("/orders").and(accept(MediaType.APPLICATION_JSON)), handler::list)
                .andRoute(GET("/orders/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::getById);
    }
}
