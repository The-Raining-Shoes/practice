package com.example.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ItemApplication {

	public static void main(String[] args) {
		SpringApplication arr = new SpringApplication(ItemApplication.class);
		arr.setAdditionalProfiles("application");
		arr.run(args);
//		SpringApplication.run(ItemApplication.class, args);
	}
}
