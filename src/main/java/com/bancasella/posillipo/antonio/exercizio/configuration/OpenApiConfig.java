package com.bancasella.posillipo.antonio.exercizio.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(new Info().
				title("EsercizioBancaSella").
				description("Esercizio per Banca Sella di Antonio Posillipo").
				version("1.0.0")
				.contact(new Contact().
						name("Antonio Posillipo").
						email("antonio.posillipo@libero.it")));
	}
}
