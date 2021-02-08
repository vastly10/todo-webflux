package com.practice.todo.repository;

import com.practice.todo.domain.Member;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MemberRepository extends ReactiveCrudRepository<Member, String> {

    @Query("SELECT * FROM MEMBER")
    Flux<Member> getAll();
}
