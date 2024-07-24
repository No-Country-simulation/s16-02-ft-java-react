package com.pet.api_pet;

import com.pet.api_pet.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ApiPetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPetApplication.class, args);
	}

}
