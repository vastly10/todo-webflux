package com.practice.todo.repository;

import com.practice.todo.repository.entity.Todo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TodoRepository extends ReactiveCrudRepository<Todo, Integer> {
//    @Query("UPDATE TODO SET title = $1, completed = $2, mod_time = $3 WHERE id = $4")
//    <S extends Todo> Mono<S> update(S entity);
}
