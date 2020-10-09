package com.antonioazambuja.noxus;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.resources.ChampionInfoV3;
import com.antonioazambuja.noxus.service.ChampionV3Service;

@RunWith(MockitoJUnitRunner.class)
public class ChampionV3Test {

	@Mock
    private ChampionV3Service championV3;
	
	@Test
	public void getChampionRotationTest() {
		Integer maxNewPlayerLevel = new Integer(10);
		List<Integer> freeChampionIdsForNewPlayers = Arrays.asList(new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5), new Integer(6), new Integer(7), new Integer(8));
		List<Integer> freeChampionIds = Arrays.asList(new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5), new Integer(6), new Integer(7), new Integer(8));
		ChampionInfoV3 championInfoV3 = new ChampionInfoV3(maxNewPlayerLevel, freeChampionIdsForNewPlayers, freeChampionIds);
		Mockito
	        .when(championV3.getChampionRotation())
	        .thenReturn(championInfoV3);
		Assert.assertEquals(championInfoV3, championV3.getChampionRotation());
		Mockito.verify(championV3).getChampionRotation();
	}
}
