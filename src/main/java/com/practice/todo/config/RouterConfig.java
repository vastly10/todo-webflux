package com.practice.todo.config;

import com.practice.todo.handler.SampleHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class RouterConfig {

    @Bean
    public RouterFunctions.Builder baseBuilder(TodoHandlerFilters filters) {
        return RouterFunctions.route()
                .filter(filters::logging);
    }
}
