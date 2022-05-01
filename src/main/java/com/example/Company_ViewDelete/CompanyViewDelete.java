package com.example.Company_ViewDelete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CompanyViewDelete {

	public static void main(String[] args) {
		SpringApplication.run(CompanyViewDelete.class, args);
	}

}
