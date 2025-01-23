package com.juliokozarewicz.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloworldApplication {

	public static final String BASE_URL_SERVICE = "/helloworld";

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

}