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
	
	@RequestMapping("/analyze/top/{summonerName}")
	public List<MatchDto> getTopLaneMatchesBySummoner(@PathVariable(value="summonerName") String summonerName) {
		return summonerAnalyze.getTopLaneMatchesBySummoner(summonerName);
	}
	
	@RequestMapping("/analyze/mid/{summonerName}")
	public List<MatchDto> getMidLaneMatchesBySummoner(@PathVariable(value="summonerName") String summonerName) {
		return summonerAnalyze.getMidLaneMatchesBySummoner(summonerName);
	}
	
	@RequestMapping("/analyze/bottom/{summonerName}")
	public List<MatchDto> getBottomLaneMatchesBySummoner(@PathVariable(value="summonerName") String summonerName) {
		return summonerAnalyze.getBotLaneMatchesBySummoner(summonerName);
	}

	@RequestMapping("/analyze/jungle/{summonerName}")
	public List<MatchDto> getJungleLaneMatchesBySummoner(@PathVariable(value="summonerName") String summonerName) {
		return summonerAnalyze.getJungleLaneMatchesBySummoner(summonerName);
	}

}
