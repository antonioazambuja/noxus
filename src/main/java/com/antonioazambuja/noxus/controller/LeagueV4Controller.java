package com.antonioazambuja.noxus.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.LeagueEntryDTO;
import com.antonioazambuja.noxus.resources.LeagueListDTO;
import com.antonioazambuja.noxus.service.LeagueV4Service;

@RestController
public class LeagueV4Controller {

	@Autowired
	private LeagueV4Service leagueV4;
	
	@RequestMapping("/league/challenger/{queue}")
	public LeagueListDTO getChallengerQueue(@PathVariable(value="queue") String queue) {
		return leagueV4.getChallengerLeaguesByQueue(queue);
	}
	
	@RequestMapping("/league/grandmaster/{queue}")
	public LeagueListDTO getGrandmasterQueue(@PathVariable(value="queue") String queue) {
		return leagueV4.getGrandmasterLeaguesByQueue(queue);
	}
	
	@RequestMapping("/league/master/{queue}")
	public LeagueListDTO getMasterQueue(@PathVariable(value="queue") String queue) {
		return leagueV4.getMasterLeaguesByQueue(queue);
	}
	
	@RequestMapping("/league/entries/by-summoner/{encryptedSummonerId}")
	public ArrayList<LeagueEntryDTO> getEntriesBySummoner(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId) {
		return new ArrayList<LeagueEntryDTO>(Arrays.asList(leagueV4.getEntriesBySummoner(encryptedSummonerId)));
	}
	
	@RequestMapping("/league/entries/{queue}/{tier}/{division}")
	public ArrayList<LeagueEntryDTO> getEntriesByQueueTierDivision(@PathVariable(value="queue") String queue,
			@PathVariable(value="tier") String tier,
			@PathVariable(value="division") String division) {
		return new ArrayList<LeagueEntryDTO>(Arrays.asList(leagueV4.getEntriesByQueueTierDivision(queue, tier, division)));
	}

	@RequestMapping("/league/by-id/{leagueId}")
	public LeagueListDTO getChampionRotation(@PathVariable(value="leagueId") String leagueId) {
		return leagueV4.getLeagueById(leagueId);
	}

}
