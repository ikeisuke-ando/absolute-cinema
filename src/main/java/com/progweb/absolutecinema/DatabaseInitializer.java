package com.progweb.absolutecinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
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

                    ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM user");
                    resultSet.next();
                    int users = resultSet.getInt(1);

                    if (users == 0) {
                        statement.execute("INSERT INTO `user` (user_id, username, name, password) VALUES " +
                                "(1, 'Admin', 'Administrador', '$2a$12$BwNUS0ozkisqnxeEBV6.GOr4f5jfhCLNQgSmbGIpiYUaY/lhXnQI6'), " +
                                "(2, 'Usu', 'Usuario', '$2a$10$Vg4CdtP7RjPm4qDTN9WtbeGdr0Onj9YlQgQPHbrO4YJS1tKzR1WY2')");
                    }
                }
            }
        };
    }
}
