package com.msa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	// 스프링부트의 기본 포트는 8080
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/posts/**")	// posts로 시작하는 모든 path
						.uri("http://localhost:8081"))
				.route(p -> p
						.path("/comments/**")	// comments로 시작하는 모든 path
						.uri("http://localhost:8082"))
				.build();
	}
}
