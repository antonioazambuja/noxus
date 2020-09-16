package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ChampionInfoV3;

@Service
public class ChampionV3 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;
	
	public ChampionInfoV3 getChampionRotation() {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<ChampionInfoV3> championInfo = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/platform/v3/champion-rotations",
				HttpMethod.GET,
				request,
				ChampionInfoV3.class
		);
		return championInfo.getBody();
	}
}
