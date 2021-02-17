package com.practice.todo.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;
import org.springframework.data.annotation.Id;

@Data
@With
@AllArgsConstructor
public class Todo {
    @Id
    private int id;
    private String title;
    private boolean completed;
}
