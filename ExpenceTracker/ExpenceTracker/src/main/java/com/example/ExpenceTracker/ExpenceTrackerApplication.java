package com.example.ExpenceTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ExpenceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenceTrackerApplication.class, args);
	}

}
