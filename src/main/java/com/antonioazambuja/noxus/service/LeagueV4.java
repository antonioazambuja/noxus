package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.LeagueListDTO;

@Service
public class LeagueV4 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;
	
	public LeagueListDTO getChallengerLeaguesByQueue(String queueName) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<LeagueListDTO> leagueListDTO = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/league/v4/challengerleagues/by-queue/{queueName}",
				HttpMethod.GET,
				request,
				LeagueListDTO.class,
				queueName
		);
		return leagueListDTO.getBody();
	}
}
