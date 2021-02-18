package com.practice.todo.config;

import com.practice.todo.repository.TodoRepository;
import com.practice.todo.repository.entity.Todo;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.mapping.event.BeforeConvertCallback;
import org.springframework.data.r2dbc.mapping.event.BeforeSaveCallback;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.DatabasePopulator;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Configuration
@EnableR2dbcAuditing
public class DatabaseConfig {

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(localResourcePopulator());
        return initializer;
    }

    private DatabasePopulator localResourcePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(new ClassPathResource("/schema.sql"));
        populator.addScripts(new ClassPathResource("/data.sql"));
        return populator;
    }

    @Bean
    public BeforeConvertCallback<Todo> createIdCallback(DatabaseClient client) {
        return (entity, table) -> {
            if (isCreate(entity)) {
                return client
                        .sql("SELECT TODO_ID_SEQ.nextval")
                        .map(row -> row.get(0, Long.class))
                        .first()
                        .map(key -> new Todo(key, entity.getTitle(), entity.isCompleted(), entity.getRegTime(), entity.getModTime()));
            }
            return Mono.just(entity);
        };
    }

    private boolean isCreate(Todo todo) {
        return todo.getId() == 0;
    }
}
