package com.antonioazambuja.noxus.controller.ChampionMasteryV4;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.ChampionMasteryV4.ChampionMasteryDTO;
import com.antonioazambuja.noxus.service.ChampionMasteryV4.ChampionMasteryService;

@RestController
public class ChampionMasteryController {

	@Autowired
	private ChampionMasteryService championMasteryService;
	
	@RequestMapping("/champion/mastery/{encryptedSummonerId}")
	public ArrayList<ChampionMasteryDTO> getChampionMasteries(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId) {
		return new ArrayList<ChampionMasteryDTO>(Arrays.asList(championMasteryService.getChampionMasteries(encryptedSummonerId)));
	}
}
