package com.antonioazambuja.noxus.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ChampionMasteryDTO;

@Service
public class ChampionMastery {

//	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	public ChampionMasteryDTO[] getChampionMasteries(String encryptedSummonerId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", "RGAPI-5adac329-9c25-489f-bf96-5973da9b54a0");
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
	
	public ChampionMasteryDTO getChampionMasterySummonerByID(String encryptedSummonerId, String championId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", "RGAPI-5adac329-9c25-489f-bf96-5973da9b54a0");
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
}
