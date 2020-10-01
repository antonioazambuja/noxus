package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ChampionInfoV3;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Service
public class ChampionV3 {

	private static final String CHAMPION_V3_CACHE_ID = "champion_v3";

	@Autowired
	private Gson gson;

	@Autowired
	private Jedis redisClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;
	
	public ChampionInfoV3 getChampionRotation() {
		String cacheKey = CHAMPION_V3_CACHE_ID + "_rotation";
		ChampionInfoV3 cacheResult = gson.fromJson(redisClient.get(cacheKey), ChampionInfoV3.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<ChampionInfoV3> championInfo = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/platform/v3/champion-rotations",
				HttpMethod.GET,
				request,
				ChampionInfoV3.class
		);
		redisClient.set(cacheKey, gson.toJson(championInfo.getBody()));
		return championInfo.getBody();
	}
}
