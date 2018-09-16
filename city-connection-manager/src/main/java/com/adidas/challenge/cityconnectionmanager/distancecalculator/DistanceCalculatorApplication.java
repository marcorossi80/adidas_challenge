package com.adidas.challenge.cityconnectionmanager.distancecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableAutoConfiguration
public class DistanceCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistanceCalculatorApplication.class, args);
	}
}
