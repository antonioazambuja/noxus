package com.antonioazambuja.noxus.service.ChampionMasteryV4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ChampionMasteryV4.ChampionMasteryDTO;

@Service
public class ChampionMasteryService {

//	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	public ChampionMasteryDTO[] getChampionMasteries(String encryptedSummonerId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", "RGAPI-5adac329-9c25-489f-bf96-5973da9b54a0");
		HttpEntity request = new HttpEntity<>(headers);
		ResponseEntity<ChampionMasteryDTO[]> championMasteries = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				request,
				ChampionMasteryDTO[].class,
				encryptedSummonerId
		);
//		ChampionMasteryDTO[] championMasteries = restTemplate.getForObject("https://br1.api.riotgames.com" + encryptedSummonerId, ChampionMasteryDTO[].class);
		return championMasteries.getBody();
	}
}
