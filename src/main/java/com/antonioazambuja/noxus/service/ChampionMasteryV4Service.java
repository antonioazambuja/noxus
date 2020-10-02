package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ChampionMasteryDTO;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Service
public class ChampionMasteryV4Service {

	private static final String CHAMPION_MASTERY_CACHE_ID = "champion_mastery_";

	@Autowired
	private RedisUtilsService redisUtils;

	@Autowired
	private Gson gson;

	@Autowired
	private Jedis redisClient;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpEntity<Object> request;

	@Value("${RIOT_API}")
	private String riotApi;

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public ChampionMasteryDTO[] getChampionMasteries(String encryptedSummonerId) {
		String cacheKey = CHAMPION_MASTERY_CACHE_ID + encryptedSummonerId;
		ChampionMasteryDTO[] cacheResult = gson.fromJson(redisClient.get(cacheKey), ChampionMasteryDTO[].class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<ChampionMasteryDTO[]> championMasteries = restTemplate.exchange(
				riotApi + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				ChampionMasteryDTO[].class,
				encryptedSummonerId
		);
		redisClient.set(cacheKey, gson.toJson(championMasteries.getBody()));
		redisUtils.expireAt(cacheKey);
		return championMasteries.getBody();
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public ChampionMasteryDTO getChampionMasteryByID(String encryptedSummonerId, String championId) {
		String cacheKey = CHAMPION_MASTERY_CACHE_ID + encryptedSummonerId + "_" + championId;
		ChampionMasteryDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), ChampionMasteryDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<ChampionMasteryDTO> championMastery = restTemplate.exchange(
				riotApi + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}",
				HttpMethod.GET,
				request,
				ChampionMasteryDTO.class,
				encryptedSummonerId,
				championId
		);
		redisClient.set(cacheKey, gson.toJson(championMastery.getBody()));
		redisUtils.expireAt(cacheKey);
		return championMastery.getBody();
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public Integer getScores(String encryptedSummonerId) {
		String cacheKey = CHAMPION_MASTERY_CACHE_ID + "scores_" + encryptedSummonerId;
		Integer cacheResult = gson.fromJson(redisClient.get(cacheKey), Integer.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<Integer> summonerScore = restTemplate.exchange(
				riotApi + "/lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				Integer.class,
				encryptedSummonerId
		);
		redisClient.set(cacheKey, gson.toJson(summonerScore.getBody()));
		redisUtils.expireAt(cacheKey);
		return summonerScore.getBody();
	}
}
