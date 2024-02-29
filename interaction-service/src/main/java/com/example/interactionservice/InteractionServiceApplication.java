package com.example.interactionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InteractionServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InteractionServiceApplication.class, args);
	}

}
