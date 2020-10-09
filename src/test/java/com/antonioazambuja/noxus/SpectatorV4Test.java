package com.antonioazambuja.noxus;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.resources.BannedChampion;
import com.antonioazambuja.noxus.resources.CurrentGameInfo;
import com.antonioazambuja.noxus.resources.FeaturedGame;
import com.antonioazambuja.noxus.resources.FeaturedGameInfo;
import com.antonioazambuja.noxus.resources.MasteryDto;
import com.antonioazambuja.noxus.resources.Observer;
import com.antonioazambuja.noxus.resources.ParticipantDto;
import com.antonioazambuja.noxus.resources.ParticipantStatsDto;
import com.antonioazambuja.noxus.resources.ParticipantTimelineDto;
import com.antonioazambuja.noxus.resources.RuneDto;
import com.antonioazambuja.noxus.service.SpectatorV4Service;

@RunWith(MockitoJUnitRunner.class)
public class SpectatorV4Test {

	@Mock
    private SpectatorV4Service spectatorV4Service;
	
	@Test
	public void getFeaturedGamesTest() {
		FeaturedGame featuredGame = new FeaturedGame(
				Arrays.asList(new FeaturedGameInfo("gameMode", new Long(0), new Long(0), "gameType", Arrays.asList(new BannedChampion(new Integer(0), new Long(0), new Long(0))), new Long(0), new Observer("encryptionKey"), new Long(0), new Long(0), Arrays.asList(new ParticipantDto(new Integer(0), new Integer(0),
						Arrays.asList(new RuneDto(new Integer(0), new Integer(0))),
						new ParticipantStatsDto(new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), true, new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), true, new Long(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Long(0), new Long(0), new Integer(0), new Long(0), new Long(0), new Integer(0), new Integer(0), true, new Integer(0), new Integer(0), new Integer(0), true, new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), true, new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), true, new Long(0), new Integer(0), new Long(0), new Long(0), true, new Integer(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Long(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)),
						new Integer(0),
						new ParticipantTimelineDto(),
						new Integer(0),
						new Integer(0),
						"UNRANKED",
						Arrays.asList(new MasteryDto(new Integer(0), new Integer(0))))), "platformId")), new Long(0));
		Mockito
		.when(spectatorV4Service.getFeaturedGames())
		.thenReturn(featuredGame);
		Assert.assertEquals(spectatorV4Service.getFeaturedGames(), featuredGame);
		Mockito.verify(spectatorV4Service).getFeaturedGames();
	}

	@Test
	public void getActiveGamesBySummonerTest() {
		String encryptedSummonerId = "encryptedSummonerId";
		CurrentGameInfo currentGameInfo = new CurrentGameInfo(new Long(0), 
				"gameType", 
				new Long(0), 
				new Long(0), 
				new Long(0), 
				"platformId", 
				"gameMode",
				Arrays.asList(new BannedChampion(new Integer(0), new Long(0), new Long(0))), 
				new Long(0), 
				new Observer("encryptionKey"), 
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
			.when(spectatorV4Service.getActiveGamesBySummoner(encryptedSummonerId))
			.thenReturn(currentGameInfo);
		Assert.assertEquals(spectatorV4Service.getActiveGamesBySummoner(encryptedSummonerId), currentGameInfo);
		Mockito.verify(spectatorV4Service).getActiveGamesBySummoner(encryptedSummonerId);
	}
}


























