package com.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.anji.captcha", "com.cinema"})
@SpringBootApplication
public class CinemaAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaAdminApplication.class, args);
	}

}
