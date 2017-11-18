package com.demo.keeptuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application starter
 */
@SpringBootApplication
@EnableAutoConfiguration
public class KeeptuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeeptuitApplication.class, args);
	}
}
