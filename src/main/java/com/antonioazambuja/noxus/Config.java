package com.antonioazambuja.noxus;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@EnableRetry
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
	public Jedis jedisClient() throws URISyntaxException {
		return new Jedis(new URI(redisURI));
	}

	@Bean
	public JedisPool jedisPool() throws URISyntaxException {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
	    poolConfig.setMaxTotal(1100);
	    poolConfig.setMaxIdle(16);
	    poolConfig.setMinIdle(10);
	    poolConfig.setTestOnBorrow(true);
	    poolConfig.setTestOnReturn(true);
	    poolConfig.setTestWhileIdle(true);poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
	    poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
	    poolConfig.setNumTestsPerEvictionRun(3);
	    poolConfig.setBlockWhenExhausted(true);
		return new JedisPool(poolConfig, new URI(redisURI));
	}

	@Bean
	public HttpEntity<Object> httpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", riotApiKey);
		return new HttpEntity<>(headers);
	}

}
