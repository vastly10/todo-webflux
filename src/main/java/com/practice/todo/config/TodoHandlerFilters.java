package com.practice.todo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TodoHandlerFilters {

    Mono<ServerResponse> logging(ServerRequest request, HandlerFunction<ServerResponse> next) {
        log.info("============ in filter ============");
        return next.handle(request);
    }
}
