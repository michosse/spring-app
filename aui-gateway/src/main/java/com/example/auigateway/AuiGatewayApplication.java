package com.example.auigateway;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class AuiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder,
									 @Value("${aui.mechanic.url}") String mechanicURL,
									 @Value("${aui.car.url}") String carURL,
									 @Value("${aui.gateway.host}") String host){
		return builder
				.routes()
				.route("mechanics", route -> route
						.host(host)
						.and()
						.path("/api/mechanics/{nip}","/api/mechanics","/api/mechanic","/api/mechanics/{nip}","/api/mechanic/{nip}")
						.uri(mechanicURL))
				.route("cars", route -> route
						.host(host)
						.and()
						.path("/api/cars/{vin}","/api/mechanics/{nip}/cars","/api/cars","/api/car","/api/cars/{vin}","/api/cars/{vin}")
						.uri(carURL))
				.build();
	}
	@Bean
	public CorsWebFilter corsWebFilter() {

		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT", "PATCH"));
		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}

}
