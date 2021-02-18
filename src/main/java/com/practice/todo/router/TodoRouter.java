package com.practice.todo.router;

import com.practice.todo.handler.TodoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;

@Configuration
public class TodoRouter {

    @Bean
    RouterFunction<ServerResponse> routeTodo(TodoHandler handler) {
        return RouterFunctions.route()
                .path("/todo", builder -> builder
                    .GET("/all", handler::findAllTodo)
                    .POST("/delete", handler::deleteTodo)
                    .POST("/save", handler::saveTodo)
                    .POST("/save-all", handler::saveAllTodo)
                    .POST("/update", handler::updateTodo)
                    .POST("/update-all", handler::updateAllTodo))
                .build();
    }
}
