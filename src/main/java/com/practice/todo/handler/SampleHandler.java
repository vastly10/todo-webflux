package com.practice.todo.handler;

import com.practice.todo.domain.Member;
import com.practice.todo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

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
