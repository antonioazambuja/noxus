package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ChampionMasteryDTO;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Service
public class ChampionMasteryV4 {

	private static final String CHAMPION_MASTERY_CACHE_ID = "champion_mastery_";

	@Autowired
	private Gson gson;

	@Autowired
	private Jedis redisClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;

	public ChampionMasteryDTO[] getChampionMasteries(String encryptedSummonerId) {
		String cacheKey = CHAMPION_MASTERY_CACHE_ID + encryptedSummonerId;
		ChampionMasteryDTO[] cacheResult = gson.fromJson(redisClient.get(cacheKey), ChampionMasteryDTO[].class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<ChampionMasteryDTO[]> championMasteries = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				ChampionMasteryDTO[].class,
				encryptedSummonerId
		);
		redisClient.set(cacheKey, gson.toJson(championMasteries.getBody()));
		return championMasteries.getBody();
	}
	
	public ChampionMasteryDTO getChampionMasteryByID(String encryptedSummonerId, String championId) {
		String cacheKey = CHAMPION_MASTERY_CACHE_ID + encryptedSummonerId + "_" + championId;
		ChampionMasteryDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), ChampionMasteryDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<ChampionMasteryDTO> championMastery = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}",
				HttpMethod.GET,
				request,
				ChampionMasteryDTO.class,
				encryptedSummonerId,
				championId
		);
		redisClient.set(cacheKey, gson.toJson(championMastery.getBody()));
		return championMastery.getBody();
	}
	
	public Integer getScores(String encryptedSummonerId) {
		String cacheKey = CHAMPION_MASTERY_CACHE_ID + "scores_" + encryptedSummonerId;
		Integer cacheResult = gson.fromJson(redisClient.get(cacheKey), Integer.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<Integer> summonerScore = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				Integer.class,
				encryptedSummonerId
		);
		redisClient.set(cacheKey, gson.toJson(summonerScore.getBody()));
		return summonerScore.getBody();
	}
}
