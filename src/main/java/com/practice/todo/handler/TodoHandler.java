package com.practice.todo.handler;

import com.practice.todo.repository.TodoRepository;
import com.practice.todo.repository.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TodoHandler {

    private final TodoRepository repository;

    public Mono<ServerResponse> findAllTodo(ServerRequest req) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(repository.findAll(), Todo.class);
    }

    public Mono<ServerResponse> deleteTodo(ServerRequest req) {
        return req.bodyToMono(Integer.class)
                .flatMap(id -> ServerResponse.ok().build(repository.deleteById(id)));
    }

    public Mono<ServerResponse> saveTodo(ServerRequest req) {
        return req.bodyToMono(Todo.class)
                .flatMap(repository::save)
                .flatMap(todoMono -> ServerResponse.ok().bodyValue(todoMono));
    }

    public Mono<ServerResponse> saveAllTodo(ServerRequest req) {
        Flux<Todo> updateTodo = req.bodyToFlux(Todo.class);
        return repository.saveAll(updateTodo)
                .collectList()
                .flatMap(list -> ServerResponse.ok().bodyValue(list));
    }

    public Mono<ServerResponse> updateTodo(ServerRequest req) {
        return req.bodyToMono(Todo.class)
                .flatMap(repository::update)
                .flatMap(result -> ServerResponse.ok().build());
    }

    public Mono<ServerResponse> updateAllTodo(ServerRequest req) {
        Flux<Todo> updateTodo = req.bodyToFlux(Todo.class);
        return repository.updateAll(updateTodo)
                .collectList()
                .flatMap(list -> ServerResponse.ok().bodyValue(list));
    }
}
