package com.electronics.samsung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SamsungApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamsungApplication.class, args);
	}

}
