package com.practice.todo.repository.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@ToString
@Table
public class Todo {
    @Id
    private long id;
    private String title;
    private boolean completed;
    @CreatedDate
    private LocalDateTime regTime;
    @LastModifiedDate
    private LocalDateTime modTime;
}

