package com.endava.ticketsjavabackend;

import com.endava.ticketsjavabackend.repository.RefreshJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = RefreshJpaRepositoryImpl.class)
public class TicketsJavaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketsJavaBackendApplication.class, args);
    }

}
