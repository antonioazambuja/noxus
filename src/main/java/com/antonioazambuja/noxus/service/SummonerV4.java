package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.SummonerDTO;

@Service
public class SummonerV4 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;
	
	public SummonerDTO getSummonerByEncryptedAccountId(String encryptedAccountId) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/summoner/v4/summoners/by-account/{encryptedAccountId}",
				HttpMethod.GET,
				request,
				SummonerDTO.class,
				encryptedAccountId
				);
		return summonerDTO.getBody();
	}

	public SummonerDTO getSummonerByName(String summonerName) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/summoner/v4/summoners/by-name/{summonerName}",
				HttpMethod.GET,
				request,
				SummonerDTO.class,
				summonerName
				);
		return summonerDTO.getBody();
	}

	public SummonerDTO getSummonerByPuuid(String encryptedPuuid) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/summoner/v4/summoners/by-puuid/{encryptedPuuid}",
				HttpMethod.GET,
				request,
				SummonerDTO.class,
				encryptedPuuid
				);
		return summonerDTO.getBody();
	}

	public SummonerDTO getSummonerById(String encryptedSummonerId) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<SummonerDTO> summonerDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/summoner/v4/summoners/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				SummonerDTO.class,
				encryptedSummonerId
		);
		return summonerDTO.getBody();
	}
}
