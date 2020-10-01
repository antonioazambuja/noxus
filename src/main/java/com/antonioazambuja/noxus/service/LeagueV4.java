package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.LeagueListDTO;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Service
public class LeagueV4 {

	private static final String LEAGUE_V4_CACHE_ID = "league_v4_";

	@Autowired
	private Gson gson;

	@Autowired
	private Jedis redisClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;
	
	public LeagueListDTO getChallengerLeaguesByQueue(String queueName) {
		String cacheKey = LEAGUE_V4_CACHE_ID + "challenger_queue_" + queueName;
		LeagueListDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), LeagueListDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<LeagueListDTO> leagueListDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/league/v4/challengerleagues/by-queue/{queueName}",
				HttpMethod.GET,
				request,
				LeagueListDTO.class,
				queueName
		);
		redisClient.set(cacheKey, gson.toJson(leagueListDTO.getBody()));
		return leagueListDTO.getBody();
	}
}
