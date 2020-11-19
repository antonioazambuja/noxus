package com.antonioazambuja.noxus.service;

import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.exceptions.NotFoundCacheException;
import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchTimelineDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.antonioazambuja.noxus.resources.RiotURI;
import com.antonioazambuja.noxus.resources.SummonerDTO;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class MatchV4Service {

	private static final String MATCH_V4_CACHE_ID = "match_v4_";

	@Autowired
	private RedisService redisUtils;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;

	@Value("${RIOT_API}")
	private String riotApi;

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public MatchDto getMatchById(Long matchId) {
		String cacheKey = MATCH_V4_CACHE_ID + matchId;
		try {
			MatchDto cacheResult = redisUtils.getCache(cacheKey, MatchDto.class);
			return cacheResult;
		} catch (NotFoundCacheException e) {
			ResponseEntity<MatchDto> matchDto = restTemplate.exchange(
					riotApi + "/lol/match/v4/matches/{matchId}",
					HttpMethod.GET,
					request,
					MatchDto.class,
					matchId
					);
			redisUtils.setCache(cacheKey, matchDto);
			redisUtils.expireAt(cacheKey);
			return matchDto.getBody();
		}
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public MatchTimelineDto getTimelineMatchById(String matchId) {
		String cacheKey = MATCH_V4_CACHE_ID + "timeline_" + matchId;
		try {
			MatchTimelineDto cacheResult = redisUtils.getCache(cacheKey, MatchTimelineDto.class);
			return cacheResult;
		} catch (NotFoundCacheException e) {
			ResponseEntity<MatchTimelineDto> matchDto = restTemplate.exchange(
					riotApi + "/lol/match/v4/timelines/by-match/{matchId}",
					HttpMethod.GET,
					request,
					MatchTimelineDto.class,
					matchId
					);
			redisUtils.setCache(cacheKey, matchDto);
			redisUtils.expireAt(cacheKey);
			return matchDto.getBody();
		}
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex) {
		// criar resource para gerenciar criação de novas keys complexas para cache redis
		String cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_" + endTime)
			.append("_" + beginTime)
			.append("_" + endIndex)
			.append("_" + beginIndex).toString();
		try {
			MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class);
			return cacheResult;
		} catch (NotFoundCacheException e) {
			ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
					new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
						.setStringQueryParam("endTime", endTime.toString())
						.setStringQueryParam("beginTime", beginTime.toString())
						.setStringQueryParam("endIndex", endIndex.toString())
						.setStringQueryParam("beginIndex", beginIndex.toString())
						.getRiotURL()
						.toUriString(),
					HttpMethod.GET,
					request,
					MatchlistDto.class,
					encryptedAccountId
					);
			redisUtils.setCache(cacheKey, matchlistDto);
			redisUtils.expireAt(cacheKey);
			return matchlistDto.getBody();
		}
	}
	
	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex) {
		// criar resource para gerenciar criação de novas keys complexas para cache redis
		// criar resource para gerenciar criação de novas keys complexas para cache redis
		String cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_" + endTime)
			.append("_" + beginTime)
			.append("_" + endIndex)
			.append("_" + beginIndex).toString();
		try {
			MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class);
			return cacheResult;
		} catch (NotFoundCacheException e) {
			ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
					new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
						.setStringQueryParam("endTime", endTime.toString())
						.setStringQueryParam("beginTime", beginTime.toString())
						.setStringQueryParam("endIndex", endIndex.toString())
						.setStringQueryParam("beginIndex", beginIndex.toString())
						.getRiotURL()
						.toUriString(),
					HttpMethod.GET,
					request,
					MatchlistDto.class,
					encryptedAccountId
					);
			redisUtils.setCache(cacheKey, matchlistDto);
			redisUtils.expireAt(cacheKey);
			return matchlistDto.getBody();
		}
		String cacheKey = new StringBuilder()
				.append(MATCH_V4_CACHE_ID)
				.append("matches")
				.append("_").append(encryptedAccountId)
				.append("_" + String.join("_", champion.stream().map(item -> item.toString()).collect(Collectors.toSet())))
				.append("_" + endTime)
				.append("_" + beginTime)
				.append("_" + endIndex)
				.append("_" + beginIndex).toString();
		MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class);
		String requestURI = new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
				.setIterableQueryParam("champion", champion)
				.setStringQueryParam("endTime", endTime.toString())
				.setStringQueryParam("beginTime", beginTime.toString())
				.setStringQueryParam("endIndex", endIndex.toString())
				.setStringQueryParam("beginIndex", beginIndex.toString())
				.getRiotURL()
				.toUriString();
		ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
				requestURI,
				HttpMethod.GET,
				request,
				MatchlistDto.class,
				encryptedAccountId
				);
		redisClient.set(cacheKey.toString(), gson.toJson(matchlistDto.getBody()));
		redisUtils.expireAt(cacheKey.toString());
		redisClient.close();
		return matchlistDto.getBody();
	}

//	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
//	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, HashSet<Integer> queue, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex) {
//		// criar resource para gerenciar criação de novas keys complexas para cache redis
//		StringBuilder cacheKey = new StringBuilder()
//			.append(MATCH_V4_CACHE_ID)
//			.append("matches")
//			.append("_").append(encryptedAccountId)
//			.append("_" + String.join("_", champion.stream().map(item -> item.toString()).collect(Collectors.toSet())))
//			.append("_" + String.join("_", queue.stream().map(item -> item.toString()).collect(Collectors.toSet())))
//			.append("_" + endTime)
//			.append("_" + beginTime)
//			.append("_" + endIndex)
//			.append("_" + beginIndex);
//		MatchlistDto cacheResult = gson.fromJson(redisClient.get(cacheKey.toString()), MatchlistDto.class);
//		if (cacheResult != null) {
//			return cacheResult;
//		}
//		System.out.println(champion);
//		String requestURI = new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
//			.setIterableQueryParam("champion", champion)
//			.setIterableQueryParam("queue", queue)
//			.setStringQueryParam("endTime", endTime.toString())
//			.setStringQueryParam("beginTime", beginTime.toString())
//			.setStringQueryParam("endIndex", endIndex.toString())
//			.setStringQueryParam("beginIndex", beginIndex.toString())
//			.getRiotURL()
//			.toUriString();
//		ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
//				requestURI,
//				HttpMethod.GET,
//				request,
//				MatchlistDto.class,
//				encryptedAccountId
//				);
//		redisClient.set(cacheKey.toString(), gson.toJson(matchlistDto.getBody()));
//		redisUtils.expireAt(cacheKey.toString());
//		redisClient.close();
//		return matchlistDto.getBody();
//	}
//	
//	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
//	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, HashSet<Integer> queue, HashSet<Integer> season, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex) {
//		// criar resource para gerenciar criação de novas keys complexas para cache redis
//		StringBuilder cacheKey = new StringBuilder()
//				.append(MATCH_V4_CACHE_ID)
//				.append("matches")
//				.append("_").append(encryptedAccountId)
//				.append("_" + String.join("_", champion.stream().map(item -> item.toString()).collect(Collectors.toSet())))
//				.append("_" + String.join("_", queue.stream().map(item -> item.toString()).collect(Collectors.toSet())))
//				.append("_" + String.join("_", season.stream().map(item -> item.toString()).collect(Collectors.toSet())))
//				.append("_" + endTime)
//				.append("_" + beginTime)
//				.append("_" + endIndex)
//				.append("_" + beginIndex);
//		MatchlistDto cacheResult = gson.fromJson(redisClient.get(cacheKey.toString()), MatchlistDto.class);
//		if (cacheResult != null) {
//			return cacheResult;
//		}
//		System.out.println(champion);
//		String requestURI = new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
//				.setIterableQueryParam("champion", champion)
//				.setIterableQueryParam("queue", queue)
//				.setIterableQueryParam("season", season)
//				.setStringQueryParam("endTime", endTime.toString())
//				.setStringQueryParam("beginTime", beginTime.toString())
//				.setStringQueryParam("endIndex", endIndex.toString())
//				.setStringQueryParam("beginIndex", beginIndex.toString())
//				.getRiotURL()
//				.toUriString();
//		ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
//				requestURI,
//				HttpMethod.GET,
//				request,
//				MatchlistDto.class,
//				encryptedAccountId
//				);
//		redisClient.set(cacheKey.toString(), gson.toJson(matchlistDto.getBody()));
//		redisUtils.expireAt(cacheKey.toString());
//		redisClient.close();
//		return matchlistDto.getBody();
//	}
//
	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, Integer endIndex, Integer beginIndex) {
		// criar resource para gerenciar criação de novas keys complexas para cache redis
		Jedis redisClient = redisPool.getResource();
		StringBuilder cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_" + endIndex)
			.append("_" + beginIndex);
		MatchlistDto cacheResult = gson.fromJson(redisClient.get(cacheKey.toString()), MatchlistDto.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		String requestURI = new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
			.setStringQueryParam("endIndex", endIndex.toString())
			.setStringQueryParam("beginIndex", beginIndex.toString())
			.getRiotURL()
			.toUriString();
		ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
				requestURI,
				HttpMethod.GET,
				request,
				MatchlistDto.class,
				encryptedAccountId
				);
		redisClient.set(cacheKey.toString(), gson.toJson(matchlistDto.getBody()));
		redisUtils.expireAt(cacheKey.toString());
		redisClient.close();
		return matchlistDto.getBody();
	}

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, Integer endIndex, Integer beginIndex) {
		// criar resource para gerenciar criação de novas keys complexas para cache redis
		Jedis redisClient = redisPool.getResource();
		StringBuilder cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_" + String.join("_", champion.stream().map(item -> item.toString()).collect(Collectors.toSet())))
			.append("_" + endIndex)
			.append("_" + beginIndex);
		MatchlistDto cacheResult = gson.fromJson(redisClient.get(cacheKey.toString()), MatchlistDto.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		String requestURI = new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
			.setStringQueryParam("endIndex", endIndex.toString())
			.setStringQueryParam("beginIndex", beginIndex.toString())
			.setIterableQueryParam("champion", champion)
			.getRiotURL()
			.toUriString();
		ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
				requestURI,
				HttpMethod.GET,
				request,
				MatchlistDto.class,
				encryptedAccountId
				);
		redisClient.set(cacheKey.toString(), gson.toJson(matchlistDto.getBody()));
		redisUtils.expireAt(cacheKey.toString());
		redisClient.close();
		return matchlistDto.getBody();
	}
}
