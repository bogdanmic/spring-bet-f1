package com.spring.betf1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BetF1Application {

	public static void main(String[] args) {
		SpringApplication.run(BetF1Application.class, args);
	}

}
