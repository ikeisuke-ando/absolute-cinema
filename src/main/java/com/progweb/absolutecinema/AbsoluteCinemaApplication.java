package com.progweb.absolutecinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AbsoluteCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbsoluteCinemaApplication.class, args);
	}

}
