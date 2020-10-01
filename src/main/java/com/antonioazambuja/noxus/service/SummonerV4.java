package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.SummonerDTO;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Service
public class SummonerV4 {

	private static final String SUMMONER_V4_CACHE_ID = "summoner_v4_";

	@Autowired
	private Gson gson;

	@Autowired
	private Jedis redisClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;
	
	public SummonerDTO getSummonerByEncryptedAccountId(String encryptedAccountId) {
		String cacheKey = SUMMONER_V4_CACHE_ID + encryptedAccountId;
		SummonerDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), SummonerDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/summoner/v4/summoners/by-account/{encryptedAccountId}",
				HttpMethod.GET,
				request,
				SummonerDTO.class,
				encryptedAccountId
				);
		redisClient.set(cacheKey, gson.toJson(summonerDTO.getBody()));
		return summonerDTO.getBody();
	}

	public SummonerDTO getSummonerByName(String summonerName) {
		String cacheKey = SUMMONER_V4_CACHE_ID + summonerName;
		SummonerDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), SummonerDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/summoner/v4/summoners/by-name/{summonerName}",
				HttpMethod.GET,
				request,
				SummonerDTO.class,
				summonerName
				);
		redisClient.set(cacheKey, gson.toJson(summonerDTO.getBody()));
		return summonerDTO.getBody();
	}

	public SummonerDTO getSummonerByPuuid(String encryptedPuuid) {
		String cacheKey = SUMMONER_V4_CACHE_ID + encryptedPuuid;
		SummonerDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), SummonerDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/summoner/v4/summoners/by-puuid/{encryptedPuuid}",
				HttpMethod.GET,
				request,
				SummonerDTO.class,
				encryptedPuuid
				);
		redisClient.set(cacheKey, gson.toJson(summonerDTO.getBody()));
		return summonerDTO.getBody();
	}

	public SummonerDTO getSummonerById(String encryptedSummonerId) {
		String cacheKey = SUMMONER_V4_CACHE_ID + encryptedSummonerId;
		SummonerDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), SummonerDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/summoner/v4/summoners/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				SummonerDTO.class,
				encryptedSummonerId
		);
		redisClient.set(cacheKey, gson.toJson(summonerDTO.getBody()));
		return summonerDTO.getBody();
	}
}
