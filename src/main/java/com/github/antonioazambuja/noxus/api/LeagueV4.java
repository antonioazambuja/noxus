package com.github.antonioazambuja.noxus.api;

import com.github.antonioazambuja.noxus.resources.LeagueEntryDTO;
import com.github.antonioazambuja.noxus.resources.LeagueListDTO;

public interface LeagueV4 {
	LeagueListDTO getChallengerLeaguesByQueue(String queueName);
	LeagueEntryDTO[] getEntriesBySummoner(String encryptedSummonerId);
	LeagueEntryDTO[] getEntriesByQueueTierDivision(String queue, String tier, String division);
	LeagueListDTO getGrandmasterLeaguesByQueue(String queue);
	LeagueListDTO getLeagueById(String leagueId);
	LeagueListDTO getMasterLeaguesByQueue(String queue);
}
