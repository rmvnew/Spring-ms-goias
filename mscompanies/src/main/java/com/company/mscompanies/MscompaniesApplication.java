package com.company.mscompanies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscompaniesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscompaniesApplication.class, args);
	}

}
