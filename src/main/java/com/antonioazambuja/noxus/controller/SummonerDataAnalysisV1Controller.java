package com.antonioazambuja.noxus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.SummonerChampionMatchesDataAnalysisV1;
import com.antonioazambuja.noxus.resources.SummonerLaneMatchesDataAnalysisV1;
import com.antonioazambuja.noxus.service.SummonerDataAnalysisV1Service;

@RestController
public class SummonerDataAnalysisV1Controller {

	@Autowired
	private SummonerDataAnalysisV1Service summonerAnalyzeV1;
	
	@RequestMapping("/data/analysis/v1/by-lane/{lane}/{summonerName}")
	public SummonerLaneMatchesDataAnalysisV1 getLaneMatchesDataAnalysisV1(@PathVariable(value="summonerName") String summonerName, @PathVariable(value="lane") String lane) {
		return summonerAnalyzeV1.getLaneMatchesDataAnalysisV1(lane, summonerName);
	}

	@RequestMapping("/data/analysis/v1/by-champion/{champion}/{summonerName}")
	public SummonerChampionMatchesDataAnalysisV1 getChampionMatchesDataAnalysisV1(@PathVariable(value="summonerName") String summonerName, @PathVariable(value="champion") Integer champion) {
		return summonerAnalyzeV1.getChampionMatchesDataAnalysisV1(champion, summonerName);
	}

}
