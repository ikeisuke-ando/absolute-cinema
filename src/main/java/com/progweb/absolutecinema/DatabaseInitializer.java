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

                    statement.execute("INSERT INTO `user` (id, admin, email, login, name, password) VALUES " +
                        "(1, True, 'admin@admin.com', 'Admin', 'Administrador', 'root123'), " +
                        "(2, False, 'usuario@usuario.com', 'Usu', 'Usuario', 'user123')");


                }
            }
        };
    }
}
