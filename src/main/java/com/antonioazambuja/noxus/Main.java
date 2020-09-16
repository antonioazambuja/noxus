package com.antonioazambuja.noxus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.antonioazambuja.noxus", "com.antonioazambuja.noxus.controller", "com.antonioazambuja.noxus.resources", "com.antonioazambuja.noxus.service"})
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
