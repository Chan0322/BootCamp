package com.msa.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RefreshScope
public class GatewayApplication {

	// 스프링부트의 기본 포트는 8080

	@Value("${rest.api.url1}")
	private String url1;

	@Value("${rest.api.url2}")
	private String url2;

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		System.out.println(url1+":"+url2);
		return builder.routes()
				.route(p -> p
						.path("/posts/**")	// posts로 시작하는 모든 path
						.uri("http://localhost:8081"))
				.route(p -> p
						.path("/comments/**")	// comments로 시작하는 모든 path
						.uri("http://localhost:8082"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
