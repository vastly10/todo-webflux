package com.practice.todo;

import com.practice.todo.repository.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;

@SpringBootTest
class TodoApplicationTests {

    @Autowired
    R2dbcEntityTemplate template;

    @Test
    void contextLoads() {

        Todo todo = template.select(Todo.class).all().blockLast();
        System.out.println(todo);
    }

    @Test
    void dbTest() {
        Todo todo = new Todo(1, "update", false, null, null);
        int result = template.update(Todo.class)
                .inTable("todo")
                .matching(Query.query(Criteria.where("id").is(todo.getId())))
                .apply(Update.update("title", todo.getTitle())
                        .set("completed", todo.isCompleted()))
                .block();
        System.out.println(result);
    }

}
