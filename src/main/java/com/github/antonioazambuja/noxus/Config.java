package com.github.antonioazambuja.noxus;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Config {

	private String riotApiKey;

	private Regions region;

	public Config(String riotApiKey, Regions region) {
		this.riotApiKey = riotApiKey;
		this.region = region;
	}

	public String getRiotApiKey() {
		return riotApiKey;
	}

	public void setRiotApiKey(String riotApiKey) {
		this.riotApiKey = riotApiKey;
	}

	public Regions getRegion() {
		return region;
	}

	public void setRegion(Regions region) {
		this.region = region;
	}

	public HttpEntity<Object> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", riotApiKey);
		return new HttpEntity<>(headers);
	}

	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
