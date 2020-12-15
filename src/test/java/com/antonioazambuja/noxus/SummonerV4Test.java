package com.antonioazambuja.noxus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.resources.SummonerDTO;
import com.antonioazambuja.noxus.service.SummonerV4Service;

@RunWith(MockitoJUnitRunner.class)
public class SummonerV4Test {

	@Mock
    private SummonerV4Service summonerV4Service;
	
	@Test
	public void getSummonerByEncryptedAccountIdTest() {
		String encryptedAccountId = "encryptedAccountId";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
		.when(summonerV4Service.getSummonerByEncryptedAccountId(encryptedAccountId, false))
		.thenReturn(summonerDTO);
		Assert.assertEquals(summonerV4Service.getSummonerByEncryptedAccountId(encryptedAccountId, false), summonerDTO);
		Mockito.verify(summonerV4Service).getSummonerByEncryptedAccountId(encryptedAccountId, false);
	}
	
	@Test
	public void getSummonerByNameTest() {
		String summonerName = "summonerName";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
		.when(summonerV4Service.getSummonerByName(summonerName, false))
		.thenReturn(summonerDTO);
		Assert.assertEquals(summonerV4Service.getSummonerByName(summonerName, false), summonerDTO);
		Mockito.verify(summonerV4Service).getSummonerByName(summonerName, false);
	}
	
	@Test
	public void getSummonerByPuuidTest() {
		String encryptedPuuid = "encryptedPuuid";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
		.when(summonerV4Service.getSummonerByPuuid(encryptedPuuid, false))
		.thenReturn(summonerDTO);
		Assert.assertEquals(summonerV4Service.getSummonerByPuuid(encryptedPuuid, false), summonerDTO);
		Mockito.verify(summonerV4Service).getSummonerByPuuid(encryptedPuuid, false);
	}
	
	@Test
	public void getSummonerByIdTest() {
		String encryptedSummonerId = "encryptedSummonerId";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
		.when(summonerV4Service.getSummonerById(encryptedSummonerId, false))
		.thenReturn(summonerDTO);
		Assert.assertEquals(summonerV4Service.getSummonerById(encryptedSummonerId, false), summonerDTO);
		Mockito.verify(summonerV4Service).getSummonerById(encryptedSummonerId, false);
	}
}
