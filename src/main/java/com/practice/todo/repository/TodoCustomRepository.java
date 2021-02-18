package com.practice.todo.repository;

import com.practice.todo.repository.entity.Todo;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TodoCustomRepository {

    Mono<Integer> update(Todo todo);
    Flux<Integer> updateAll(Publisher<Todo> iterable);
}
