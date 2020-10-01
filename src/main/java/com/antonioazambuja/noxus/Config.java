package com.antonioazambuja.noxus;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Configuration
public class Config {

	@Value("${configuration.redis.uri}")
	private String redisURI;

	@Value("${configuration.riot.api.key}")
	private String riotApiKey;

	@Bean
	public RestTemplate restTemplate() { return new RestTemplate(); }

	@Bean
	public Gson gson() { return new Gson(); }

	@Bean
	public Jedis jedisClient() throws URISyntaxException { return new Jedis(new URI(redisURI)); }

	@Bean
	public HttpEntity<Object> httpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", riotApiKey);
		return new HttpEntity<>(headers);
	}

}
