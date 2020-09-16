package com.antonioazambuja.noxus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	@Bean
	public RestTemplate restTemplate() { return new RestTemplate(); }

	@Bean
	public HttpHeaders httpHeaders() { 
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", "RGAPI-5adac329-9c25-489f-bf96-5973da9b54a0");
		return headers;
	}
}
