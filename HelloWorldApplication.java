package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testcontainers.containers.MySQLContainer;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        // Create and start the MySQLContainer
        try (MySQLContainer mysqlContainer = new MySQLContainer<>("mysql:latest")
                .withDatabaseName("testdb")
                .withUsername("user")
                .withPassword("password")) {

            mysqlContainer.start();

            // Set the MySQLContainer properties as system properties
            System.setProperty("spring.datasource.url", mysqlContainer.getJdbcUrl());
            System.setProperty("spring.datasource.username", mysqlContainer.getUsername());
            System.setProperty("spring.datasource.password", mysqlContainer.getPassword());

            // Start the Spring Boot application
            SpringApplication.run(HelloWorldApplication.class, args);
        }
    }
}
