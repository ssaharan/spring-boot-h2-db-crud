package com.bezkoder.spring.jpa.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bezkoder.spring.jpa.h2"})
public class SpringBootJpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaH2Application.class, args);
	}

}
