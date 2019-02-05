package com.travix.medusa.crazyair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages={
		"com.travix.medusa.crazyair",
		"com.travix.medusa.crazyair.datasource",
		"com.travix.medusa.crazyair.rest",
		"com.travix.medusa.crazyair.mapper",
		"com.travix.medusa.crazyair.model"})
@EntityScan(basePackages = "com.travix.medusa.crazyair.datasource")
@EnableDiscoveryClient
public class CrazyairApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrazyairApplication.class, args);
	}

}

