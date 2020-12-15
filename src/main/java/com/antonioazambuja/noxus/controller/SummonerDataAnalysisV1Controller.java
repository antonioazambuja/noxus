package com.antonioazambuja.noxus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.SummonerDataChampionV1;
import com.antonioazambuja.noxus.resources.SummonerDataLaneV1;
import com.antonioazambuja.noxus.service.SummonerDataV1Service;

@RestController
public class SummonerDataAnalysisV1Controller {

	@Autowired
	private SummonerDataV1Service summonerDataV1Service;
	
	@RequestMapping("/summoner/{summonerName}/by-lane/{lane}")
	public SummonerDataLaneV1 getLaneMatchesDataAnalysisV1(@PathVariable(value="summonerName") String summonerName,
			@PathVariable(value="lane") String lane,
			@RequestParam(value="updateCache", required = false, defaultValue = "false") Boolean updateCache) {
		return summonerDataV1Service.getLaneMatchesDataAnalysisV1(lane, summonerName, updateCache);
	}

	@RequestMapping("/summoner/{summonerName}/by-champion/{champion}")
	public SummonerDataChampionV1 getChampionMatchesDataAnalysisV1(@PathVariable(value="summonerName") String summonerName,
			@PathVariable(value="champion") Integer champion, 
			@RequestParam(value="updateCache", required = false, defaultValue = "false") Boolean updateCache) {
		return summonerDataV1Service.getChampionMatchesDataAnalysisV1(champion, summonerName, updateCache);
	}

}
