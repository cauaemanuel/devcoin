package com.devcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DevcoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevcoinApplication.class, args);
	}

}
