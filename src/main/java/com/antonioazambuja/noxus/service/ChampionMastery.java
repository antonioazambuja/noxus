package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ChampionMasteryDTO;

@Service
public class ChampionMastery {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;

	public ChampionMasteryDTO[] getChampionMasteries(String encryptedSummonerId) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<ChampionMasteryDTO[]> championMasteries = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				ChampionMasteryDTO[].class,
				encryptedSummonerId
		);
		return championMasteries.getBody();
	}
	
	public ChampionMasteryDTO getChampionMasteryByID(String encryptedSummonerId, String championId) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<ChampionMasteryDTO> championMastery = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}",
				HttpMethod.GET,
				request,
				ChampionMasteryDTO.class,
				encryptedSummonerId,
				championId
		);
		return championMastery.getBody();
	}
	
	public Integer getScores(String encryptedSummonerId) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<Integer> summonerScore = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				Integer.class,
				encryptedSummonerId
		);
		return summonerScore.getBody();
	}
}
