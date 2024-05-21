package com.example.keycloakbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})


public class KeycloakBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakBackendApplication.class, args);
	}

}
