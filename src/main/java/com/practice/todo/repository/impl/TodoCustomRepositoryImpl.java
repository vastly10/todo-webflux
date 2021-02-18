package com.practice.todo.repository.impl;

import com.practice.todo.repository.TodoCustomRepository;
import com.practice.todo.repository.entity.Todo;
import org.reactivestreams.Publisher;
import org.springframework.data.auditing.AuditingHandlerSupport;
import org.springframework.data.mapping.callback.EntityCallback;
import org.springframework.data.mapping.callback.ReactiveEntityCallbacks;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.mapping.event.BeforeConvertCallback;
import org.springframework.data.r2dbc.mapping.event.ReactiveAuditingEntityCallback;
import org.springframework.data.r2dbc.repository.support.SimpleR2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class TodoCustomRepositoryImpl implements TodoCustomRepository {

    private final R2dbcEntityTemplate template;

    public TodoCustomRepositoryImpl(R2dbcEntityTemplate template) {
        this.template = template;
    }

    @Override
    public Mono<Integer> update(Todo todo) {
//        return template
//                .update(Todo.class)
//                .inTable("todo")
//                .matching(Query.query(Criteria.where("id").is(todo.getId())))
//                .apply(Update.update("title", todo.getTitle())
//                        .set("completed", todo.isCompleted()));
//                        .set("mod_time", LocalDateTime.now()));
        return template.update(
                Query.query(Criteria.where("id").is(todo.getId())),
                Update.update("title", todo.getTitle())
                    .set("completed", todo.isCompleted())
                    .set("mod_time", LocalDateTime.now()),
                Todo.class
        );
//        return template.update(todo);
    }

    @Override
    public Flux<Integer> updateAll(Publisher<Todo> publisher) {
        return Flux.from(publisher).concatMap(this::update);
    }
}
