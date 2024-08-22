package com.example.twrental;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TwrentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwrentalApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Application is running!");
            Thread.sleep(Long.MAX_VALUE);
        };
    }
}
