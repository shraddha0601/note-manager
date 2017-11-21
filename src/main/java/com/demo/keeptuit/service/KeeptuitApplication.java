package com.demo.keeptuit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Application starter
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class KeeptuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeeptuitApplication.class, args);
	}
}
