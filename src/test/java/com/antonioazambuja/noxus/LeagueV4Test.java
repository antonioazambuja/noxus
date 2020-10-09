package com.antonioazambuja.noxus;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.resources.LeagueEntryDTO;
import com.antonioazambuja.noxus.resources.LeagueItemDTO;
import com.antonioazambuja.noxus.resources.LeagueListDTO;
import com.antonioazambuja.noxus.resources.MiniSeriesDTO;
import com.antonioazambuja.noxus.service.LeagueV4Service;

@RunWith(MockitoJUnitRunner.class)
public class LeagueV4Test {

	@Mock
    private LeagueV4Service leagueV4;

	@Test
	public void getChallengerLeaguesByQueueTest() {
		String rankedSolo5x5 = "RANKED_SOLO_5x5";
		LeagueListDTO leagueListDTO = new LeagueListDTO("6870131b-2440-3229-993f-42e2f895da3d",
				Arrays.asList(new LeagueItemDTO(false, new Integer(909), "riotApiTest", null, false, false, true, "I", new Integer(1524), new Integer(600), "MPkPwVAqpCmNhXeE3sNsSCR2LqtnpIm6ZLD7HmuIs5WJ")),
				"CHALLENGER",
				"Janna's Defiants",
				"RANKED_SOLO_5x5");
		Mockito
		.when(leagueV4.getChallengerLeaguesByQueue(rankedSolo5x5))
		.thenReturn(leagueListDTO);
		Assert.assertEquals(leagueListDTO, leagueV4.getChallengerLeaguesByQueue(rankedSolo5x5));
		Mockito.verify(leagueV4).getChallengerLeaguesByQueue(rankedSolo5x5);
	}

	@Test
	public void getEntriesBySummonerTest() {
		String encryptedSummonerId = "encryptedSummonerIdTest";
		String leagueId = "6870131b-2440-3229-993f-42e2f895da3d";
		String summonerId = "summonerIdTest";
		String summonerName = "summonerNameTest";
		String queueType = "RANKED_SOLO_5x5";
		String tier = "PLATINUM";
		String rank = "I";
		Integer leaguePoints = new Integer(25);
		Integer wins = new Integer(38);
		Integer losses = new Integer(44);
		Boolean hotStreak = false;
		Boolean veteran = false;
		Boolean freshBlood = false;
		Boolean inactive = false;
		MiniSeriesDTO miniSeriesDTO = new MiniSeriesDTO();
		LeagueEntryDTO[] leagueEntryDTO = new LeagueEntryDTO[] {
				new LeagueEntryDTO(leagueId, summonerId, summonerName, queueType, tier, rank, leaguePoints, wins,
						losses, hotStreak, veteran, freshBlood, inactive, miniSeriesDTO)
				};
		Mockito
			.when(leagueV4.getEntriesBySummoner(encryptedSummonerId))
			.thenReturn(leagueEntryDTO);
		Assert.assertArrayEquals(leagueEntryDTO, leagueV4.getEntriesBySummoner(encryptedSummonerId));
		Mockito.verify(leagueV4).getEntriesBySummoner(encryptedSummonerId);
	}

	@Test
	public void getEntriesByQueueTierDivisionTest() {
		String leagueId = "6870131b-2440-3229-993f-42e2f895da3d";
		String summonerId = "summonerIdTest";
		String summonerName = "summonerNameTest";
		String queueType = "RANKED_SOLO_5x5";
		String tier = "PLATINUM";
		String rank = "I";
		Integer leaguePoints = new Integer(25);
		Integer wins = new Integer(38);
		Integer losses = new Integer(44);
		Boolean hotStreak = false;
		Boolean veteran = false;
		Boolean freshBlood = false;
		Boolean inactive = false;
		MiniSeriesDTO miniSeriesDTO = new MiniSeriesDTO();
		String divisionReq = "I";
		String queueReq = "RANKED_SOLO_5x5";
		String tierReq = "PLATINUM";
		LeagueEntryDTO[] leagueEntryDTO = new LeagueEntryDTO[] {
        		new LeagueEntryDTO(leagueId, summonerId, summonerName, queueType, tier, rank, leaguePoints, wins,
        				losses, hotStreak, veteran, freshBlood, inactive, miniSeriesDTO)
        		};
		Mockito
	        .when(leagueV4.getEntriesByQueueTierDivision(queueReq, tierReq, divisionReq))
	        .thenReturn(leagueEntryDTO);
		Assert.assertArrayEquals(leagueEntryDTO, leagueV4.getEntriesByQueueTierDivision(queueReq, tierReq, divisionReq));
		Mockito.verify(leagueV4).getEntriesByQueueTierDivision(queueReq, tierReq, divisionReq);
	}

	@Test
	public void getGrandmasterLeaguesByQueueTest() {
		String rankedSolo5x5 = "RANKED_SOLO_5x5";
		LeagueListDTO leagueListDTO = new LeagueListDTO("6870131b-2440-3229-993f-42e2f895da3d",
				Arrays.asList(new LeagueItemDTO(false, new Integer(909), "riotApiTest", null, false, false, true, "I", new Integer(1524), new Integer(600), "MPkPwVAqpCmNhXeE3sNsSCR2LqtnpIm6ZLD7HmuIs5WJ")),
				"CHALLENGER",
				"Janna's Defiants",
				"RANKED_SOLO_5x5");
		Mockito
			.when(leagueV4.getGrandmasterLeaguesByQueue(rankedSolo5x5))
			.thenReturn(leagueListDTO);
		Assert.assertEquals(leagueListDTO, leagueV4.getGrandmasterLeaguesByQueue(rankedSolo5x5));
		Mockito.verify(leagueV4).getGrandmasterLeaguesByQueue(rankedSolo5x5);
	}

	@Test
	public void getMasterLeaguesByQueueTest() {
		String rankedSolo5x5 = "RANKED_SOLO_5x5";
		LeagueListDTO leagueListDTO = new LeagueListDTO("6870131b-2440-3229-993f-42e2f895da3d",
				Arrays.asList(new LeagueItemDTO(false, new Integer(909), "riotApiTest", null, false, false, true, "I", new Integer(1524), new Integer(600), "MPkPwVAqpCmNhXeE3sNsSCR2LqtnpIm6ZLD7HmuIs5WJ")),
				"CHALLENGER",
				"Janna's Defiants",
				"RANKED_SOLO_5x5");
		Mockito
			.when(leagueV4.getMasterLeaguesByQueue(rankedSolo5x5))
			.thenReturn(leagueListDTO);
		Assert.assertEquals(leagueV4.getMasterLeaguesByQueue(rankedSolo5x5), leagueListDTO);
		Mockito.verify(leagueV4).getMasterLeaguesByQueue(rankedSolo5x5);
	}

	@Test
	public void getLeagueByIdTest() {
		String leagueId = "testLeagueId";
		LeagueListDTO leagueListDTO = new LeagueListDTO("6870131b-2440-3229-993f-42e2f895da3d",
				Arrays.asList(new LeagueItemDTO(false, new Integer(909), "riotApiTest", null, false, false, true, "I", new Integer(1524), new Integer(600), "MPkPwVAqpCmNhXeE3sNsSCR2LqtnpIm6ZLD7HmuIs5WJ")),
				"CHALLENGER",
				"Janna's Defiants",
				"RANKED_SOLO_5x5");
		Mockito
			.when(leagueV4.getLeagueById(leagueId))
			.thenReturn(leagueListDTO);
		Assert.assertEquals(leagueListDTO, leagueV4.getLeagueById(leagueId));
		Mockito.verify(leagueV4).getLeagueById(leagueId);
	}
}
