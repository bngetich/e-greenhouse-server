package com.brian.egreenhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EgreenhouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgreenhouseApplication.class, args);
	}
}
