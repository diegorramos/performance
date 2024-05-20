package io.diegorramos.javanonblocking.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public abstract class AbstractHandler {
    
    public <T> Mono<ServerResponse> response(T body, HttpStatus status) {
        return ServerResponse
                .status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body));
    }
}
