package com.practice.todo.repository;

import com.practice.todo.repository.entity.Todo;
import reactor.core.publisher.Mono;

public interface TodoCustomRepository {

    Mono<Integer> update(Todo todo);
}
