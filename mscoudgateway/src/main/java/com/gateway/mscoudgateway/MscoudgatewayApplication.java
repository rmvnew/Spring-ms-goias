package com.gateway.mscoudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MscoudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscoudgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder
				.routes()
				.route(r -> r.path("/users/**").uri("lb://msusers"))
				.route(r -> r.path("/companies/**").uri("lb://mscompanies"))
				.route(r -> r.path("/oauth/**").uri("lb://msoauth"))
				.build();
	}

}
