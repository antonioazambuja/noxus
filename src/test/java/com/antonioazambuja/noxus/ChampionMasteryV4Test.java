package com.antonioazambuja.noxus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.resources.ChampionMasteryDTO;
import com.antonioazambuja.noxus.service.ChampionMasteryV4Service;

@RunWith(MockitoJUnitRunner.class)
public class ChampionMasteryV4Test {
	@Mock
	ChampionMasteryV4Service championMasteryService;
	
	@Test
	public void getChampionMasteriesTest() {
		String encryptedSummoner = "encryptedSummonerIdTest";
		ChampionMasteryDTO[] championsMasteriesOfUser = new ChampionMasteryDTO[]{new ChampionMasteryDTO(new Long(10), true, new Long(1),
    			new Long("1577847600000"), 20, "summonerIdTest", new Integer(1000000),
    			new Long("100000"), new Integer(1))};
		Mockito
	        .when(championMasteryService.getChampionMasteries(encryptedSummoner))
	        .thenReturn(championsMasteriesOfUser);
		Assert.assertArrayEquals(championMasteryService.getChampionMasteries(encryptedSummoner), championsMasteriesOfUser);
		Mockito.verify(championMasteryService).getChampionMasteries(encryptedSummoner);
	}
	
	@Test
	public void getChampionMasteryByIDTest() {
		String encryptedSummonerId = "encryptedSummonerIdTest";
		String championId = "1";
		ChampionMasteryDTO championMastery = new ChampionMasteryDTO(new Long(10), true, new Long(1),
				new Long("1577847600000"), 20, "summonerIdTest", new Integer(1000000),
				new Long("100000"), new Integer(1));
		Mockito
			.when(championMasteryService.getChampionMasteryByID(encryptedSummonerId, championId))
			.thenReturn(championMastery);
		Assert.assertEquals(championMasteryService.getChampionMasteryByID(encryptedSummonerId, championId), championMastery);
		Mockito.verify(championMasteryService).getChampionMasteryByID(encryptedSummonerId, championId);
	}

	@Test
	public void getScoresTest() {
		String encryptedSummonerId = "encryptedSummonerIdTest";
		Integer championMasteriesScores = new Integer(27);
		Mockito
	        .when(championMasteryService.getScores(encryptedSummonerId))
	        .thenReturn(championMasteriesScores);
		Assert.assertEquals(championMasteriesScores, championMasteryService.getScores(encryptedSummonerId));
		Mockito.verify(championMasteryService).getScores(encryptedSummonerId);
	}
}
