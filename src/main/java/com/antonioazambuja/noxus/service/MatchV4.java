package com.antonioazambuja.noxus.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchTimelineDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;

@Service
public class MatchV4 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;
	
	public MatchDto getMatchById(String matchId) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<MatchDto> matchDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/match/v4/matches/{matchId}",
				HttpMethod.GET,
				request,
				MatchDto.class,
				matchId
				);
		return matchDTO.getBody();
	}

	public MatchTimelineDto getTimelineMatchById(String matchId) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<MatchTimelineDto> matchTimelineDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/match/v4/timelines/by-match/{matchId}",
				HttpMethod.GET,
				request,
				MatchTimelineDto.class,
				matchId
				);
		return matchTimelineDTO.getBody();
	}

	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, HashSet<Integer> queue, HashSet<Integer> season, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
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
		return matchlistDto.getBody();
	}

}
