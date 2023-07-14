package com.demo.heroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class BackendHeroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendHeroesApplication.class, args);
	}

}
