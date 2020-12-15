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

import com.antonioazambuja.noxus.exceptions.CacheException;
import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchTimelineDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.antonioazambuja.noxus.resources.RiotURI;

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
	public MatchDto getMatchById(Long matchId, Boolean updateCache) {
		String cacheKey = MATCH_V4_CACHE_ID + matchId;
		try {
			MatchDto cacheResult = redisUtils.getCache(cacheKey, MatchDto.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
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
	public MatchTimelineDto getTimelineMatchById(String matchId, Boolean updateCache) {
		String cacheKey = MATCH_V4_CACHE_ID + "timeline_" + matchId;
		try {
			MatchTimelineDto cacheResult = redisUtils.getCache(cacheKey, MatchTimelineDto.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
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
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex, Boolean updateCache) {
		String cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_" + endTime)
			.append("_" + beginTime)
			.append("_" + endIndex)
			.append("_" + beginIndex).toString();
		try {
			MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
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
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex, Boolean updateCache) {
		String cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_" + endTime)
			.append("_" + beginTime)
			.append("_" + endIndex)
			.append("_" + beginIndex).toString();
		try {
			MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
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
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, HashSet<Integer> queue, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex, Boolean updateCache) {
		String cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_" + String.join("_", champion.stream().map(item -> item.toString()).collect(Collectors.toSet())))
			.append("_" + String.join("_", queue.stream().map(item -> item.toString()).collect(Collectors.toSet())))
			.append("_" + endTime)
			.append("_" + beginTime)
			.append("_" + endIndex)
			.append("_" + beginIndex).toString();
		try {
			MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
			ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
					new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
						.setIterableQueryParam("champion", champion)
						.setIterableQueryParam("queue", queue)
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
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, HashSet<Integer> queue, HashSet<Integer> season, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex, Boolean updateCache) {
		String cacheKey = new StringBuilder()
				.append(MATCH_V4_CACHE_ID)
				.append("matches")
				.append("_").append(encryptedAccountId)
				.append("_" + String.join("_", champion.stream().map(item -> item.toString()).collect(Collectors.toSet())))
				.append("_" + String.join("_", queue.stream().map(item -> item.toString()).collect(Collectors.toSet())))
				.append("_" + String.join("_", season.stream().map(item -> item.toString()).collect(Collectors.toSet())))
				.append("_" + endTime)
				.append("_" + beginTime)
				.append("_" + endIndex)
				.append("_" + beginIndex).toString();
		try {
			MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
			ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
					new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
						.setIterableQueryParam("champion", champion)
						.setIterableQueryParam("queue", queue)
						.setIterableQueryParam("season", season)
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
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, Integer endIndex, Integer beginIndex, Boolean updateCache) {
		String cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_" + endIndex)
			.append("_" + beginIndex)
			.toString();
		try {
			MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
			ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
					new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
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
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, Integer endIndex, Integer beginIndex, Boolean updateCache) {
		String cacheKey = new StringBuilder()
				.append(MATCH_V4_CACHE_ID)
				.append("matches")
				.append("_").append(encryptedAccountId)
				.append("_" + String.join("_", champion.stream().map(item -> item.toString()).collect(Collectors.toSet())))
				.append("_" + endIndex)
				.append("_" + beginIndex).toString();
		try {
			MatchlistDto cacheResult = redisUtils.getCache(cacheKey, MatchlistDto.class, updateCache);
			return cacheResult;
		} catch (CacheException e) {
			ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
					new RiotURI(riotApi + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
						.setStringQueryParam("endIndex", endIndex.toString())
						.setStringQueryParam("beginIndex", beginIndex.toString())
						.setIterableQueryParam("champion", champion)
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
}
