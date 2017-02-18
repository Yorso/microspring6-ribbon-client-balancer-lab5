package com.jorge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * Try: http://localhost:8010 => It displays Eureka Server running
 */
@SpringBootApplication
@EnableEurekaServer
public class Microspring6EurekaServerLab5Application {

	public static void main(String[] args) {
		SpringApplication.run(Microspring6EurekaServerLab5Application.class, args);
	}
}
