package com.travix.medusa.toughjet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages={
		"com.travix.medusa.toughjet",
		"com.travix.medusa.toughjet.rest",
		"com.travix.medusa.toughjet.mapper",
		"com.travix.medusa.toughjet.model"})
@EnableDiscoveryClient
public class ToughjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToughjetApplication.class, args);
	}

}

