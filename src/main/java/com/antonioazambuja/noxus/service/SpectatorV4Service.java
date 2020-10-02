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

import com.antonioazambuja.noxus.resources.CurrentGameInfo;
import com.antonioazambuja.noxus.resources.FeaturedGame;

@Service
public class SpectatorV4Service {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;

	@Value("${RIOT_API}")
	private String riotApi;

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public FeaturedGame getFeatuedGames() {
		ResponseEntity<FeaturedGame> featuredGames = restTemplate.exchange(
				riotApi + "/lol/spectator/v4/featured-games",
				HttpMethod.GET,
				request,
				FeaturedGame.class
				);
		return featuredGames.getBody();
	}

	public CurrentGameInfo getActiveGamesBySummoner(String encryptedSummonerId) {
		ResponseEntity<CurrentGameInfo> currentGameInfo = restTemplate.exchange(
				riotApi + "/lol/spectator/v4/active-games/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				CurrentGameInfo.class,
				encryptedSummonerId
				);
		return currentGameInfo.getBody();
	}

}
