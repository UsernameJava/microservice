package com.one.two.SongService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SongServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(SongServiceApplication.class);

	public static void main(String[] args) {
		System.out.println("Current Directory = " + System.getProperty("user.dir"));
		SpringApplication.run(SongServiceApplication.class, args);
		logger.info("just a test info log");
	}

}
