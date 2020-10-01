package com.antonioazambuja.noxus.service;

import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchTimelineDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Service
public class MatchV4 {

	private static final String MATCH_V4_CACHE_ID = "match_v4_";

	@Autowired
	private Gson gson;

	@Autowired
	private Jedis redisClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;
	
	public MatchDto getMatchById(String matchId) {
		String cacheKey = MATCH_V4_CACHE_ID + matchId;
		MatchDto cacheResult = gson.fromJson(redisClient.get(cacheKey), MatchDto.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<MatchDto> matchDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/match/v4/matches/{matchId}",
				HttpMethod.GET,
				request,
				MatchDto.class,
				matchId
				);
		redisClient.set(cacheKey, gson.toJson(matchDTO.getBody()));
		return matchDTO.getBody();
	}

	public MatchTimelineDto getTimelineMatchById(String matchId) {
		String cacheKey = MATCH_V4_CACHE_ID + "timeline_" + matchId;
		MatchTimelineDto cacheResult = gson.fromJson(redisClient.get(cacheKey), MatchTimelineDto.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<MatchTimelineDto> matchTimelineDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/match/v4/timelines/by-match/{matchId}",
				HttpMethod.GET,
				request,
				MatchTimelineDto.class,
				matchId
				);
		redisClient.set(cacheKey, gson.toJson(matchTimelineDTO.getBody()));
		return matchTimelineDTO.getBody();
	}

	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, HashSet<Integer> queue, HashSet<Integer> season, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex) {
		StringBuilder cacheKey = new StringBuilder()
			.append(MATCH_V4_CACHE_ID)
			.append("matches")
			.append("_").append(encryptedAccountId)
			.append("_").append(String.join("_", champion.stream().map(item -> item.toString()).collect(Collectors.toSet())))
			.append("_").append(String.join("_", queue.stream().map(item -> item.toString()).collect(Collectors.toSet())))
			.append("_").append(String.join("_", season.stream().map(item -> item.toString()).collect(Collectors.toSet())))
			.append("_").append(endTime)
			.append("_").append(beginTime)
			.append("_").append(endIndex)
			.append("_").append(beginIndex);
		MatchlistDto cacheResult = gson.fromJson(redisClient.get(cacheKey.toString()), MatchlistDto.class);
		if (cacheResult != null) {
			return cacheResult;
		}
		ResponseEntity<MatchlistDto> matchlistDto = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/match/v4/matchlists/by-account/{encryptedAccountId}?champion={champion}?queue={queue}?season={season}?endTime={endTime}?beginTime={beginTime}?endIndex={endIndex}?beginIndex={beginIndex}",
				HttpMethod.GET,
				request,
				MatchlistDto.class,
				encryptedAccountId,
				champion,
				queue,
				season,
				endTime,
				beginTime,
				endIndex,
				beginIndex
				);
		redisClient.set(cacheKey.toString(), gson.toJson(matchlistDto.getBody()));
		return matchlistDto.getBody();
	}

}
