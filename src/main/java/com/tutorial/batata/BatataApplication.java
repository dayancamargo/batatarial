package com.tutorial.batata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BatataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatataApplication.class, args);
	}
}
