package com.progweb.absolutecinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Configuration
public class DatabaseInitializer {

    @Autowired
    private DataSource dataSource;

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            try (Connection connection = dataSource.getConnection()) {
                try (Statement statement = connection.createStatement()) {
                    statement.execute("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))");
                    statement.execute("INSERT INTO users (name, email) VALUES ('Admin', 'admin@adimin.com')");
                }
            }
        };
    }
}
