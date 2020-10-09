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
		.when(summonerV4Service.getSummonerByEncryptedAccountId(encryptedAccountId))
		.thenReturn(summonerDTO);
		Assert.assertEquals(summonerV4Service.getSummonerByEncryptedAccountId(encryptedAccountId), summonerDTO);
		Mockito.verify(summonerV4Service).getSummonerByEncryptedAccountId(encryptedAccountId);
	}
	
	@Test
	public void getSummonerByNameTest() {
		String summonerName = "summonerName";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
		.when(summonerV4Service.getSummonerByName(summonerName))
		.thenReturn(summonerDTO);
		Assert.assertEquals(summonerV4Service.getSummonerByName(summonerName), summonerDTO);
		Mockito.verify(summonerV4Service).getSummonerByName(summonerName);
	}
	
	@Test
	public void getSummonerByPuuidTest() {
		String encryptedPuuid = "encryptedPuuid";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
		.when(summonerV4Service.getSummonerByPuuid(encryptedPuuid))
		.thenReturn(summonerDTO);
		Assert.assertEquals(summonerV4Service.getSummonerByPuuid(encryptedPuuid), summonerDTO);
		Mockito.verify(summonerV4Service).getSummonerByPuuid(encryptedPuuid);
	}
	
	@Test
	public void getSummonerByIdTest() {
		String encryptedSummonerId = "encryptedSummonerId";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
		.when(summonerV4Service.getSummonerById(encryptedSummonerId))
		.thenReturn(summonerDTO);
		Assert.assertEquals(summonerV4Service.getSummonerById(encryptedSummonerId), summonerDTO);
		Mockito.verify(summonerV4Service).getSummonerById(encryptedSummonerId);
	}
}


























