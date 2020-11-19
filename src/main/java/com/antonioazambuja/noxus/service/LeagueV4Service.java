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

import com.antonioazambuja.noxus.resources.LeagueEntryDTO;
import com.antonioazambuja.noxus.resources.LeagueListDTO;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Service
public class LeagueV4Service {

	private static final String LEAGUE_V4_CACHE_ID = "league_v4_";

	@Autowired
	private RedisService redisUtils;

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
	public LeagueListDTO getChallengerLeaguesByQueue(String queueName) {
		String cacheKey = LEAGUE_V4_CACHE_ID + "challenger_queue_" + queueName;
		LeagueListDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), LeagueListDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<LeagueListDTO> leagueListDTO = restTemplate.exchange(
				riotApi + "/lol/league/v4/challengerleagues/by-queue/{queueName}",
				HttpMethod.GET,
				request,
				LeagueListDTO.class,
				queueName
				);
		redisClient.set(cacheKey, gson.toJson(leagueListDTO.getBody()));
		redisUtils.expireAt(cacheKey);
		return leagueListDTO.getBody();
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public LeagueEntryDTO[] getEntriesBySummoner(String encryptedSummonerId) {
		String cacheKey = LEAGUE_V4_CACHE_ID + "entries_" + encryptedSummonerId;
		LeagueEntryDTO[] cacheResult = gson.fromJson(redisClient.get(cacheKey), LeagueEntryDTO[].class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<LeagueEntryDTO[]> leagueEntryDTO = restTemplate.exchange(
				riotApi + "/lol/league/v4/entries/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				LeagueEntryDTO[].class,
				encryptedSummonerId
				);
		redisClient.set(cacheKey, gson.toJson(leagueEntryDTO.getBody()));
		redisUtils.expireAt(cacheKey);
		return leagueEntryDTO.getBody();
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public LeagueEntryDTO[] getEntriesByQueueTierDivision(String queue, String tier, String division) {
		String cacheKey = LEAGUE_V4_CACHE_ID + "entries_" + queue + "_" + tier + "_" + division;
		LeagueEntryDTO[] cacheResult = gson.fromJson(redisClient.get(cacheKey), LeagueEntryDTO[].class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<LeagueEntryDTO[]> leagueEntryDTO = restTemplate.exchange(
				riotApi + "/lol/league/v4/entries/{queue}/{tier}/{division}",
				HttpMethod.GET,
				request,
				LeagueEntryDTO[].class,
				queue,
				tier,
				division
				);
		redisClient.set(cacheKey, gson.toJson(leagueEntryDTO.getBody()));
		redisUtils.expireAt(cacheKey);
		return leagueEntryDTO.getBody();
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public LeagueListDTO getGrandmasterLeaguesByQueue(String queue) {
		String cacheKey = LEAGUE_V4_CACHE_ID + "grandmaster_queue_" + queue;
		LeagueListDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), LeagueListDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<LeagueListDTO> leagueEntryDTO = restTemplate.exchange(
				riotApi + "/lol/league/v4/grandmasterleagues/by-queue/{queue}",
				HttpMethod.GET,
				request,
				LeagueListDTO.class,
				queue
				);
		redisClient.set(cacheKey, gson.toJson(leagueEntryDTO.getBody()));
		redisUtils.expireAt(cacheKey);
		return leagueEntryDTO.getBody();
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public LeagueListDTO getLeagueById(String leagueId) {
		String cacheKey = LEAGUE_V4_CACHE_ID + "league_" + leagueId;
		LeagueListDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), LeagueListDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<LeagueListDTO> leagueEntryDTO = restTemplate.exchange(
				riotApi + "/lol/league/v4/leagues/{leagueId}",
				HttpMethod.GET,
				request,
				LeagueListDTO.class,
				leagueId
				);
		redisClient.set(cacheKey, gson.toJson(leagueEntryDTO.getBody()));
		redisUtils.expireAt(cacheKey);
		return leagueEntryDTO.getBody();
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public LeagueListDTO getMasterLeaguesByQueue(String queue) {
		String cacheKey = LEAGUE_V4_CACHE_ID + "masterleague_" + queue;
		LeagueListDTO cacheResult = gson.fromJson(redisClient.get(cacheKey), LeagueListDTO.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<LeagueListDTO> leagueEntryDTO = restTemplate.exchange(
				riotApi + "/lol/league/v4/masterleagues/by-queue/{queue}",
				HttpMethod.GET,
				request,
				LeagueListDTO.class,
				queue
		);
		redisClient.set(cacheKey, gson.toJson(leagueEntryDTO.getBody()));
		redisUtils.expireAt(cacheKey);
		return leagueEntryDTO.getBody();
	}
}
