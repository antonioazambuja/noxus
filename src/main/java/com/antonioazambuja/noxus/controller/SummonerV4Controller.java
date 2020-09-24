package com.antonioazambuja.noxus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.SummonerDTO;
import com.antonioazambuja.noxus.service.SummonerV4;

@RestController
public class SummonerV4Controller {

	@Autowired
	private SummonerV4 summonerV4;

	@RequestMapping("/summoner/by-account/{encryptedAccountId}")
	public SummonerDTO getSummonerByEncryptedAccountId(@PathVariable(value="encryptedAccountId") String encryptedAccountId) {
		return summonerV4.getSummonerByEncryptedAccountId(encryptedAccountId);
	}

	@RequestMapping("/summoner/by-name/{summonerName}")
	public SummonerDTO getSummonerByName(@PathVariable(value="summonerName") String summonerName) {
		return summonerV4.getSummonerByName(summonerName);
	}

	@RequestMapping("/summoner/by-puuid/{encryptedPuuid}")
	public SummonerDTO getSummonerByPuuid(@PathVariable(value="encryptedPuuid") String encryptedPuuid) {
		return summonerV4.getSummonerByPuuid(encryptedPuuid);
	}

	@RequestMapping("/summoner/by-id/{encryptedSummonerId}")
	public SummonerDTO getSummonerById(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId) {
		return summonerV4.getSummonerById(encryptedSummonerId);
	}

}
