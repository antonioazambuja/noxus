package com.github.antonioazambuja.noxus.api;

import com.github.antonioazambuja.noxus.resources.ChampionMasteryDTO;

public interface ChampionMasteryV4 {
	ChampionMasteryDTO[] getChampionMasteries(String encryptedSummonerId);
	ChampionMasteryDTO getChampionMasteryByID(String encryptedSummonerId, String championId);
	Integer getScores(String encryptedSummonerId);
}
