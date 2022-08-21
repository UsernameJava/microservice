package com.example.ResourceServiceV1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ResourceServiceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceV1Application.class, args);
	}

}
