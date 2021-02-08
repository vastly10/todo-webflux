package com.practice.todo.config;

import com.practice.todo.handler.SampleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.support.RouterFunctionMapping;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class SampleRouter {


//    public HandlerMapping addConfig(@Autowired RouterFunctionMapping mapping) {
//        mapping.getRouterFunction().filter((request, next) -> {
//            System.out.println("filter before invoke" + request.path());
//            return next.handle(request);
//        });
//    }

    @Bean
    public RouterFunction<ServerResponse> route(SampleHandler sampleHandler) {
        return RouterFunctions.route()
                .GET("/hello", sampleHandler::helloWebflux)
//                .GET("/dbTest", sampleHandler::dbTest)
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> route2(SampleHandler sampleHandler) {
        return RouterFunctions.route()
//                .GET("/hello", sampleHandler::helloWebflux)
                .GET("/dbTest", sampleHandler::dbTest)
                .build();
    }
}
