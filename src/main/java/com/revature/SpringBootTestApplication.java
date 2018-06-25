package com.revature;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class SpringBootTestApplication {	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}
