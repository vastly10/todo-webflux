package com.practice.todo.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Member {

    @Id
    private String id;
    private final String name;
    private final String email;
}
