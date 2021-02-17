package com.practice.todo.handler;

import com.practice.todo.repository.entity.Member;
import com.practice.todo.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class SampleHandler {

    private final MemberRepository memberRepository;

    public SampleHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Mono<ServerResponse> helloWebflux(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromValue("Hello, WebFlux"));
    }

    public Mono<ServerResponse> dbTest(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(memberRepository.getAll(), Member.class);
    }
}
