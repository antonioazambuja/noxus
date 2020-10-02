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
		Mockito
        .when(championMasteryService.getChampionMasteries(encryptedSummoner))
        .thenReturn(new ChampionMasteryDTO[]{new ChampionMasteryDTO(new Long(10), true, new Long(1),
        			new Long("1577847600000"), 20, "summonerIdTest", new Integer(1000000),
        			new Long("100000"), new Integer(1))});
		ChampionMasteryDTO[] championsMasteriesOfUser = championMasteryService.getChampionMasteries(encryptedSummoner);
		for (int i = 0; i < championsMasteriesOfUser.length; i++) {
		 	Assert.assertEquals(championsMasteriesOfUser[i].getSummonerId(), "summonerIdTest");
		}
	}
	
	@Test
	public void getChampionMasteryByIDTest() {
		String encryptedSummonerId = "encryptedSummonerIdTest";
		String championId = "1";
		Mockito
        .when(championMasteryService.getChampionMasteryByID(encryptedSummonerId, championId))
        .thenReturn(new ChampionMasteryDTO(new Long(10), true, new Long(1),
        			new Long("1577847600000"), 20, "summonerIdTest", new Integer(1000000),
        			new Long("100000"), new Integer(1)));
		ChampionMasteryDTO championMastery = championMasteryService.getChampionMasteryByID(encryptedSummonerId, championId);
		Assert.assertEquals(championMastery.getChampionPointsUntilNextLevel(), new Long(10));
		Assert.assertEquals(championMastery.getChestGranted(), true);
		Assert.assertEquals(championMastery.getChampionId(), new Long(1));
		Assert.assertEquals(championMastery.getLastPlayTime(), new Long("1577847600000"));
		Assert.assertEquals(championMastery.getChampionLevel(), new Integer(20));
		Assert.assertEquals(championMastery.getSummonerId(), "summonerIdTest");
		Assert.assertEquals(championMastery.getChampionPoints(), new Integer(1000000));
		Assert.assertEquals(championMastery.getChampionPointsSinceLastLevel(), new Long("100000"));
		Assert.assertEquals(championMastery.getTokensEarned(), new Integer(1));
	}
}
