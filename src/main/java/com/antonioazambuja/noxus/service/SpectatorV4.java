package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.CurrentGameInfo;
import com.antonioazambuja.noxus.resources.FeaturedGame;

@Service
public class SpectatorV4 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;
	
	public FeaturedGame getFeatuedGames() {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<FeaturedGame> featuredGames = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/spectator/v4/featured-games",
				HttpMethod.GET,
				request,
				FeaturedGame.class
				);
		return featuredGames.getBody();
	}

	public CurrentGameInfo getActiveGamesBySummoner(String encryptedSummonerId) {
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<CurrentGameInfo> currentGameInfo = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/spectator/v4/active-games/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				CurrentGameInfo.class,
				encryptedSummonerId
				);
		return currentGameInfo.getBody();
	}

}
