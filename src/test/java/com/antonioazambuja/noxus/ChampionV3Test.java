package com.antonioazambuja.noxus;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.resources.ChampionInfoV3;
import com.antonioazambuja.noxus.service.ChampionV3;

@RunWith(MockitoJUnitRunner.class)
public class ChampionV3Test {
	@Mock
    private ChampionV3 championV3;
	
	@Test
	public void getChampionRotationTest() {
		Mockito
        .when(championV3.getChampionRotation())
        .thenReturn(new ChampionInfoV3(new Integer(10), Arrays.asList(new Integer(10)), Arrays.asList(new Integer(20))));
		Assert.assertEquals(championV3.getChampionRotation().getMaxNewPlayerLevel(), new Integer(10));
	}
}
