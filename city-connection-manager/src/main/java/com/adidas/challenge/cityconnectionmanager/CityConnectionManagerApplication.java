package com.adidas.challenge.cityconnectionmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableAutoConfiguration
public class CityConnectionManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityConnectionManagerApplication.class, args);
	}
}
