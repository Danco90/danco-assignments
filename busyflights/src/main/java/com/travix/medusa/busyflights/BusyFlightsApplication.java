package com.travix.medusa.busyflights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages={
		"com.travix.medusa.busyflights",
		"com.travix.medusa.busyflights.datasource",
		"com.travix.medusa.busyflights.rest",
		"com.travix.medusa.busyflights.config",
		"com.travix.medusa.busyflights.client",
		"com.travix.medusa.busyflights.mapper",
		"com.travix.medusa.busyflights.model",
		"com.travix.medusa.busyflights.consumer"})
@EnableFeignClients(basePackages={"com.travix.medusa.busyflights.client","com.travix.medusa.busyflights.rest"})

@EnableDiscoveryClient
public class BusyFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusyFlightsApplication.class, args);
	}
	
}
