package com.estock.estockmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
@ComponentScan(basePackages={"com.estock.estockmarket.*"})
public class EstockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstockServiceApplication.class, args);
	}

}
