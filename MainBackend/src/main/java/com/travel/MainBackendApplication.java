package com.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.travel.services,com.travel.model,com.travel.repositories")
public class MainBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainBackendApplication.class, args);
	}
}
