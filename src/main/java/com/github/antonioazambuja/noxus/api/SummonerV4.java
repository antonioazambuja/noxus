package com.github.antonioazambuja.noxus.api;

import com.github.antonioazambuja.noxus.resources.SummonerDTO;

public interface SummonerV4 {
	SummonerDTO getSummonerByEncryptedAccountId(String encryptedAccountId);
	SummonerDTO getSummonerByName(String summonerName);
	SummonerDTO getSummonerByPuuid(String encryptedPuuid);
	SummonerDTO getSummonerById(String encryptedSummonerId);
}
