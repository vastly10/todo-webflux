package com.practice.todo.repository;

import com.practice.todo.repository.entity.Todo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TodoRepository extends ReactiveCrudRepository<Todo, Integer> {

}
