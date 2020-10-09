package com.antonioazambuja.noxus;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.resources.MasteryDto;
import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchReferenceDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.antonioazambuja.noxus.resources.ParticipantDto;
import com.antonioazambuja.noxus.resources.ParticipantIdentityDto;
import com.antonioazambuja.noxus.resources.ParticipantStatsDto;
import com.antonioazambuja.noxus.resources.ParticipantTimelineDto;
import com.antonioazambuja.noxus.resources.PlayerDto;
import com.antonioazambuja.noxus.resources.RuneDto;
import com.antonioazambuja.noxus.resources.TeamBansDto;
import com.antonioazambuja.noxus.resources.TeamStatsDto;
import com.antonioazambuja.noxus.service.MatchV4Service;

@RunWith(MockitoJUnitRunner.class)
public class MatchV4Test {

	@Mock
    private MatchV4Service matchV4;

	@Test
	public void getMatchByIdTest() {
		String matchId = "matchIdTest";
		MatchDto matchDto = new MatchDto(
				new Long(0),
				Arrays.asList(new ParticipantIdentityDto(new Integer(0), new PlayerDto(new Integer(0), "accountId", "matchHistoryUri", "currentAccountId", "currentPlatformId", "summonerName", "summonerId", "platformId"))),
				new Integer(0),
				"gameType",
				new Long(1577836800),
				Arrays.asList(new TeamStatsDto(new Integer(0), new Integer(0), true, new Integer(0), Arrays.asList(new TeamBansDto(new Integer(0), new Integer(0))), true, true, new Integer(0), new Integer(0), new Integer(0), true, true, new Integer(0), true, new Integer(0), "Win")),
				"platformId",
				new Long(1577836800),
				new Integer(0),
				"gameVersion",
				new Integer(0),
				"gameMode",
				Arrays.asList(new ParticipantDto(new Integer(0), new Integer(0),
						Arrays.asList(new RuneDto(new Integer(0), new Integer(0))),
						new ParticipantStatsDto(new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), true, new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), true, new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Long(0), new Long(0), new Integer(0), new Long(0), new Long(0), new Integer(0), new Integer(0), true, new Integer(0), new Integer(0), new Integer(0), true, new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), true, new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), true, new Long(0), new Integer(0), new Long(0), new Long(0), true, new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)),
						new Integer(0),
						new ParticipantTimelineDto(),
						new Integer(0),
						new Integer(0),
						"UNRANKED",
						Arrays.asList(new MasteryDto(new Integer(0), new Integer(0))))));
		Mockito
		.when(matchV4.getMatchById(matchId))
		.thenReturn(matchDto);
		Assert.assertEquals(matchV4.getMatchById(matchId), matchDto);
		Mockito.verify(matchV4).getMatchById(matchId);
	}
	
	@Test
	public void getTimelineMatchByIdTest() {
		String matchId = "matchIdTest";
		MatchDto matchDto = new MatchDto(
				new Long(0),
				Arrays.asList(new ParticipantIdentityDto(new Integer(0), new PlayerDto(new Integer(0), "accountId", "matchHistoryUri", "currentAccountId", "currentPlatformId", "summonerName", "summonerId", "platformId"))),
				new Integer(0),
				"gameType",
				new Long(1577836800),
				Arrays.asList(new TeamStatsDto(new Integer(0), new Integer(0), true, new Integer(0), Arrays.asList(new TeamBansDto(new Integer(0), new Integer(0))), true, true, new Integer(0), new Integer(0), new Integer(0), true, true, new Integer(0), true, new Integer(0), "Win")),
				"platformId",
				new Long(1577836800),
				new Integer(0),
				"gameVersion",
				new Integer(0),
				"gameMode",
				Arrays.asList(new ParticipantDto(new Integer(0), new Integer(0),
						Arrays.asList(new RuneDto(new Integer(0), new Integer(0))),
						new ParticipantStatsDto(new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), true, new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), true, new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Long(0), new Long(0), new Integer(0), new Long(0), new Long(0), new Integer(0), new Integer(0), true, new Integer(0), new Integer(0), new Integer(0), true, new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), true, new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), true, new Long(0), new Integer(0), new Long(0), new Long(0), true, new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)),
						new Integer(0),
						new ParticipantTimelineDto(),
						new Integer(0),
						new Integer(0),
						"UNRANKED",
						Arrays.asList(new MasteryDto(new Integer(0), new Integer(0))))));
		Mockito
		.when(matchV4.getMatchById(matchId))
		.thenReturn(matchDto);
		Assert.assertEquals(matchV4.getMatchById(matchId), matchDto);
		Mockito.verify(matchV4).getMatchById(matchId);
	}

	@Test
	public void getMatchesByAccountIdTest() {
		String encryptedAccountId = "encryptedAccountId";
		HashSet<Integer> champion = new HashSet<>(Arrays.asList(0,1,2));
		HashSet<Integer> queue = new HashSet<>(Arrays.asList(0,1,2));
		HashSet<Integer> season = new HashSet<>(Arrays.asList(0,1,2));
		Long endTime = new Long(0);
		Long beginTime = new Long(0);
		Integer endIndex = new Integer(0);
		Integer beginIndex = new Integer(0);
		MatchlistDto matchlistDto = new MatchlistDto(new Integer(0), new Integer(0), new Integer(0), Arrays.asList(new MatchReferenceDto(new Integer(0), "role", new Integer(0), "platformId", new Integer(0), new Integer(0), "lane", new Long(0))));
		Mockito
	        .when(matchV4.getMatchesByAccountId(encryptedAccountId, champion, queue, season, endTime, beginTime, endIndex, beginIndex))
	        .thenReturn(matchlistDto);
		Assert.assertEquals(matchV4.getMatchesByAccountId(encryptedAccountId, champion, queue, season, endTime, beginTime, endIndex, beginIndex), matchlistDto);
		Mockito.verify(matchV4).getMatchesByAccountId(encryptedAccountId, champion, queue, season, endTime, beginTime, endIndex, beginIndex);
	}
}
