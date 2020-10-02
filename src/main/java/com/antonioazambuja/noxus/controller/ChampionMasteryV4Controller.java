package com.antonioazambuja.noxus.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.ChampionMasteryDTO;
import com.antonioazambuja.noxus.service.ChampionMasteryV4Service;

@RestController
public class ChampionMasteryV4Controller {

	@Autowired
	private ChampionMasteryV4Service championMasteryV4Service;

	@RequestMapping("/champion/mastery/{encryptedSummonerId}")
	public ArrayList<ChampionMasteryDTO> getChampionMasteriesBySummonerId(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId) {
		return new ArrayList<ChampionMasteryDTO>(Arrays.asList(championMasteryV4Service.getChampionMasteries(encryptedSummonerId)));
	}

	@RequestMapping("/champion/mastery/{encryptedSummonerId}/{championId}")
	public ChampionMasteryDTO getChampionMasteryBySummonerIdAndChampionId(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId,@PathVariable(value="championId") String championId) {
		return championMasteryV4Service.getChampionMasteryByID(encryptedSummonerId, championId);
	}

	@RequestMapping("/champion/score/{encryptedSummonerId}")
	public Integer getScoreChampionMasteryBySummonerIdAndChampionId(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId) {
		return championMasteryV4Service.getScores(encryptedSummonerId);
	}
}
