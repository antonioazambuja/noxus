package com.antonioazambuja.noxus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.service.SummonerAnalyze;

@RestController
public class SummonerAnalyzeController {

	@Autowired
	private SummonerAnalyze summonerAnalyze;
	
	@RequestMapping("/analyze/win/{summonerName}")
	public List<MatchDto> getWinMatchesBySummoner(@PathVariable(value="summonerName") String summonerName) {
		return summonerAnalyze.getWinMatchesBySummoner(summonerName);
	}

	@RequestMapping("/analyze/lose/{summonerName}")
	public List<MatchDto> getLoseMatchesBySummoner(@PathVariable(value="summonerName") String summonerName) {
		return summonerAnalyze.getLoseMatchesBySummoner(summonerName);
	}

}
