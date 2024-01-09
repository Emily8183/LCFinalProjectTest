package com.skilldev.easytraveltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EasytraveltestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasytraveltestApplication.class, args);
	}

}
