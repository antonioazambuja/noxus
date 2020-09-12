package com.antonioazambuja.noxus.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.ChampionMasteryDTO;
import com.antonioazambuja.noxus.service.ChampionMastery;

@RestController
public class ChampionMasteryController {

	@Autowired
	private ChampionMastery championMasteryService;

	@RequestMapping("/champion/mastery/{encryptedSummonerId}")
	public ArrayList<ChampionMasteryDTO> getChampionMasteriesBySummonerId(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId) {
		return new ArrayList<ChampionMasteryDTO>(Arrays.asList(championMasteryService.getChampionMasteries(encryptedSummonerId)));
	}

	@RequestMapping("/champion/mastery/{encryptedSummonerId}/{championId}")
	public ChampionMasteryDTO getChampionMasteryBySummonerIdAndChampionId(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId,@PathVariable(value="championId") String championId) {
		return championMasteryService.getChampionMasteryByID(encryptedSummonerId, championId);
	}

	@RequestMapping("/champion/score/{encryptedSummonerId}")
	public Integer getScoreChampionMasteryBySummonerIdAndChampionId(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId) {
		return championMasteryService.getScores(encryptedSummonerId);
	}
}
