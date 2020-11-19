package com.antonioazambuja.noxus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.SummonerDTO;
import com.antonioazambuja.noxus.resources.SummonerDataChampionV1;
import com.antonioazambuja.noxus.resources.SummonerDataLaneV1;
import com.antonioazambuja.noxus.resources.SummonerDataV1;
import com.antonioazambuja.noxus.service.SummonerDataV1Service;
import com.antonioazambuja.noxus.service.SummonerV4Service;

@RestController
public class SummonerDataAnalysisV1Controller {

	@Autowired
	private SummonerDataV1Service summonerDataV1Service;

	@Autowired
	private SummonerV4Service summonerV4Service;
	
	@RequestMapping("/summoner/{summonerName}/by-lane/{lane}")
	public SummonerDataLaneV1 getLaneMatchesDataAnalysisV1(@PathVariable(value="summonerName") String summonerName, @PathVariable(value="lane") String lane) {
		return summonerDataV1Service.getLaneMatchesDataAnalysisV1(lane, summonerName);
	}

	@RequestMapping("/summoner/{summonerName}/by-champion/{champion}")
	public SummonerDataChampionV1 getChampionMatchesDataAnalysisV1(@PathVariable(value="summonerName") String summonerName, @PathVariable(value="champion") Integer champion) {
		return summonerDataV1Service.getChampionMatchesDataAnalysisV1(champion, summonerName);
	}

	@RequestMapping("/{summonerName}")
	public SummonerDataV1 getMatchesDataAnalysisV1(@PathVariable(value="summonerName") String summonerName) {
		return summonerDataV1Service.getMatchesDataAnalysisV1(summonerName);
	}

	@RequestMapping("/test/{encryptedAccountId}")
	public SummonerDTO getTest(@PathVariable(value="encryptedAccountId") String encryptedAccountId) {
		return summonerV4Service.getSummonerByEncryptedAccountId(encryptedAccountId);
	}

}
