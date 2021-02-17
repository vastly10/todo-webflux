package com.practice.todo.router;

import com.practice.todo.handler.SampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class SampleRouter {

    @Bean
    public RouterFunction<ServerResponse> route(RouterFunctions.Builder builder, SampleHandler handler) {
        return builder
                .GET("/hello", handler::helloWebflux)
                .GET("/dbTest", handler::dbTest)
                .build();
    }

}
