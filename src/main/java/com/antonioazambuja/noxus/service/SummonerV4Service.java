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

import com.antonioazambuja.noxus.exceptions.CacheException;
import com.antonioazambuja.noxus.resources.SummonerDTO;

@Service
public class SummonerV4Service {

	private static final String SUMMONER_V4_CACHE_ID = "summoner_v4_";

	@Autowired
	private RedisService redisUtils;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;

	@Value("${RIOT_API}")
	private String riotApi;

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public SummonerDTO getSummonerByEncryptedAccountId(String encryptedAccountId, Boolean updateCache) {
		String cacheKey = SUMMONER_V4_CACHE_ID + encryptedAccountId;
		try {
			SummonerDTO cacheResult = redisUtils.getCache(cacheKey, SummonerDTO.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
			ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
					riotApi + "/lol/summoner/v4/summoners/by-account/{encryptedAccountId}",
					HttpMethod.GET,
					request,
					SummonerDTO.class,
					encryptedAccountId
					);
			redisUtils.setCache(cacheKey, summonerDTO);
			redisUtils.expireAt(cacheKey);
			return summonerDTO.getBody();
		}
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public SummonerDTO getSummonerByName(String summonerName, Boolean updateCache) {
		String cacheKey = SUMMONER_V4_CACHE_ID + summonerName;
		try {
			SummonerDTO cacheResult = redisUtils.getCache(cacheKey, SummonerDTO.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
			ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
					riotApi + "/lol/summoner/v4/summoners/by-name/{summonerName}",
					HttpMethod.GET,
					request,
					SummonerDTO.class,
					summonerName
					);
			redisUtils.setCache(cacheKey, summonerDTO);
			redisUtils.expireAt(cacheKey);
			return summonerDTO.getBody();
		}
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public SummonerDTO getSummonerByPuuid(String encryptedPuuid, Boolean updateCache) {
		String cacheKey = SUMMONER_V4_CACHE_ID + encryptedPuuid;
		try {
			SummonerDTO cacheResult = redisUtils.getCache(cacheKey, SummonerDTO.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
			ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
					riotApi + "/lol/summoner/v4/summoners/by-puuid/{encryptedPuuid}",
					HttpMethod.GET,
					request,
					SummonerDTO.class,
					encryptedPuuid
					);
			redisUtils.setCache(cacheKey, summonerDTO);
			redisUtils.expireAt(cacheKey);
			return summonerDTO.getBody();
		}
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public SummonerDTO getSummonerById(String encryptedSummonerId, Boolean updateCache) {
		String cacheKey = SUMMONER_V4_CACHE_ID + encryptedSummonerId;
		try {
			SummonerDTO cacheResult = redisUtils.getCache(cacheKey, SummonerDTO.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
			ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
					riotApi + "/lol/summoner/v4/summoners/{encryptedSummonerId}",
					HttpMethod.GET,
					request,
					SummonerDTO.class,
					encryptedSummonerId
					);
			redisUtils.setCache(cacheKey, summonerDTO);
			redisUtils.expireAt(cacheKey);
			return summonerDTO.getBody();
		}
	}
}
