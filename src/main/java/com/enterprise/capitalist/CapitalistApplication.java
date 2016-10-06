package com.enterprise.capitalist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CapitalistApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalistApplication.class, args);
	}
}
