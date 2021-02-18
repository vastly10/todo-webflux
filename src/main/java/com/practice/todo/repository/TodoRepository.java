package com.practice.todo.repository;

import com.practice.todo.repository.entity.Todo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TodoRepository extends ReactiveCrudRepository<Todo, Integer>, TodoCustomRepository{

}
