package com.adidas.challenge.distancecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
public class DistanceCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistanceCalculatorApplication.class, args);
	}
}
