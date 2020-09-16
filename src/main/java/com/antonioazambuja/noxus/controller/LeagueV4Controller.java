package com.antonioazambuja.noxus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.LeagueListDTO;
import com.antonioazambuja.noxus.service.LeagueV4;

@RestController
public class LeagueV4Controller {

	@Autowired
	private LeagueV4 leagueV4;

	@RequestMapping("/league/challenger/{queue}")
	public LeagueListDTO getChampionRotation(@PathVariable(value="queue") String queue) {
		return leagueV4.getChallengerLeaguesByQueue(queue);
	}

}
