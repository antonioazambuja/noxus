package com.github.antonioazambuja.noxus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.antonioazambuja.noxus.resources.BannedChampion;
import com.github.antonioazambuja.noxus.resources.ChampionInfoV3;
import com.github.antonioazambuja.noxus.resources.ChampionMasteryDTO;
import com.github.antonioazambuja.noxus.resources.CurrentGameInfo;
import com.github.antonioazambuja.noxus.resources.FeaturedGame;
import com.github.antonioazambuja.noxus.resources.FeaturedGameInfo;
import com.github.antonioazambuja.noxus.resources.Incident;
import com.github.antonioazambuja.noxus.resources.LeagueEntryDTO;
import com.github.antonioazambuja.noxus.resources.LeagueItemDTO;
import com.github.antonioazambuja.noxus.resources.LeagueListDTO;
import com.github.antonioazambuja.noxus.resources.MasteryDto;
import com.github.antonioazambuja.noxus.resources.MatchDto;
import com.github.antonioazambuja.noxus.resources.MatchReferenceDto;
import com.github.antonioazambuja.noxus.resources.MatchlistDto;
import com.github.antonioazambuja.noxus.resources.Message;
import com.github.antonioazambuja.noxus.resources.MiniSeriesDTO;
import com.github.antonioazambuja.noxus.resources.Observer;
import com.github.antonioazambuja.noxus.resources.ParticipantDto;
import com.github.antonioazambuja.noxus.resources.ParticipantIdentityDto;
import com.github.antonioazambuja.noxus.resources.ParticipantStatsDto;
import com.github.antonioazambuja.noxus.resources.ParticipantTimelineDto;
import com.github.antonioazambuja.noxus.resources.PlayerDto;
import com.github.antonioazambuja.noxus.resources.RuneDto;
import com.github.antonioazambuja.noxus.resources.Service;
import com.github.antonioazambuja.noxus.resources.ShardStatus;
import com.github.antonioazambuja.noxus.resources.SummonerDTO;
import com.github.antonioazambuja.noxus.resources.TeamBansDto;
import com.github.antonioazambuja.noxus.resources.TeamStatsDto;
import com.github.antonioazambuja.noxus.resources.Translation;

@RunWith(MockitoJUnitRunner.class)
public class NoxusTest {

	@Mock
    private Noxus noxus;

	@Test
	public void getChampionRotationTest() {
		Integer maxNewPlayerLevel = new Integer(10);
		List<Integer> freeChampionIdsForNewPlayers = Arrays.asList(new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5), new Integer(6), new Integer(7), new Integer(8));
		List<Integer> freeChampionIds = Arrays.asList(new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5), new Integer(6), new Integer(7), new Integer(8));
		ChampionInfoV3 championInfoV3 = new ChampionInfoV3(maxNewPlayerLevel, freeChampionIdsForNewPlayers, freeChampionIds);
		Mockito
	        .when(noxus.getChampionRotation())
	        .thenReturn(championInfoV3);
		Assert.assertEquals(championInfoV3, noxus.getChampionRotation());
		Mockito
			.verify(noxus)
			.getChampionRotation();
	}

	@Test
	public void getSummonerByEncryptedAccountIdTest() {
		String encryptedAccountId = "encryptedAccountId";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
			.when(noxus.getSummonerByEncryptedAccountId(encryptedAccountId))
			.thenReturn(summonerDTO);
		Assert.assertEquals(noxus.getSummonerByEncryptedAccountId(encryptedAccountId), summonerDTO);
		Mockito
			.verify(noxus)
			.getSummonerByEncryptedAccountId(encryptedAccountId);
	}
	
	@Test
	public void getSummonerByNameTest() {
		String summonerName = "summonerName";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
			.when(noxus.getSummonerByName(summonerName))
			.thenReturn(summonerDTO);
		Assert.assertEquals(noxus.getSummonerByName(summonerName), summonerDTO);
		Mockito
			.verify(noxus)
			.getSummonerByName(summonerName);
	}
	
	@Test
	public void getSummonerByPuuidTest() {
		String encryptedPuuid = "encryptedPuuid";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
			.when(noxus.getSummonerByPuuid(encryptedPuuid))
			.thenReturn(summonerDTO);
		Assert.assertEquals(noxus.getSummonerByPuuid(encryptedPuuid), summonerDTO);
		Mockito
			.verify(noxus)
			.getSummonerByPuuid(encryptedPuuid);
	}
	
	@Test
	public void getSummonerByIdTest() {
		String encryptedSummonerId = "encryptedSummonerId";
		SummonerDTO summonerDTO = new SummonerDTO("accountId", new Integer(0), new Long(0), "name", "id", "puuid", new Long(0));
		Mockito
			.when(noxus.getSummonerById(encryptedSummonerId))
			.thenReturn(summonerDTO);
		Assert.assertEquals(noxus.getSummonerById(encryptedSummonerId), summonerDTO);
		Mockito
			.verify(noxus)
			.getSummonerById(encryptedSummonerId);
	}
	
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
		.when(noxus.getFeaturedGames())
		.thenReturn(featuredGame);
		Assert.assertEquals(noxus.getFeaturedGames(), featuredGame);
		Mockito
			.verify(noxus)
			.getFeaturedGames();
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
			.when(noxus.getActiveGamesBySummoner(encryptedSummonerId))
			.thenReturn(currentGameInfo);
		Assert.assertEquals(noxus.getActiveGamesBySummoner(encryptedSummonerId), currentGameInfo);
		Mockito
			.verify(noxus)
			.getActiveGamesBySummoner(encryptedSummonerId);
	}

	@Test
	public void getMatchByIdTest() {
		Long matchId = new Long(0);
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
			.when(noxus.getMatchById(matchId))
			.thenReturn(matchDto);
		Assert.assertEquals(noxus.getMatchById(matchId), matchDto);
		Mockito
			.verify(noxus)
			.getMatchById(matchId);
	}
	
	@Test
	public void getTimelineMatchByIdTest() {
		Long matchId = new Long(0);
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
			.when(noxus.getMatchById(matchId))
			.thenReturn(matchDto);
		Assert.assertEquals(noxus.getMatchById(matchId), matchDto);
		Mockito
			.verify(noxus)
			.getMatchById(matchId);
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
		MatchlistDto matchlistDto = new MatchlistDto(new Integer(0), new Integer(0), new Integer(0), Arrays.asList(new MatchReferenceDto(new Long(0), "role", new Integer(0), "platformId", new Integer(0), new Integer(0), "lane", new Long(0))));
		Mockito
	        .when(noxus.getMatchesByAccountId(encryptedAccountId, champion, queue, season, endTime, beginTime, endIndex, beginIndex))
	        .thenReturn(matchlistDto);
		Assert.assertEquals(noxus.getMatchesByAccountId(encryptedAccountId, champion, queue, season, endTime, beginTime, endIndex, beginIndex), matchlistDto);
		Mockito
			.verify(noxus)
			.getMatchesByAccountId(encryptedAccountId, champion, queue, season, endTime, beginTime, endIndex, beginIndex);
	}


	@Test
	public void getStatusShardDataTest() {
		List<String> locales = Arrays.asList("pt_BR");
		String hostname = "prod.br.lol.riotgames.com";
		String slug = "br";
		String name = "Brazil";
		String region_tag = "br1";
		String content = "Em 23/01/20, com início às 03:30 do horário de Brasília (05:30 UTC), as filas ranqueadas serão desativadas em preparação para a atualização 10.02. Às 05:00 do horário de Brasília (07:00 UTC), os servidores serão desligados, todas as partidas em andamento serão encerradas em empate e as estatísticas não serão gravadas. Estimamos que os Campos da Justiça fiquem indisponíveis por 3 horas.";
		String severity = "info";
		String created_at = "2020-01-22T02:27:04.188Z";
		String updated_at = "2020-01-22T02:27:04.188Z";
		String serviceName = "Game";
		String serviceSlug = "game";
		String status = "online";
		String messageId = "messageId";
		String authorId = "authorId";
		String heading = "10.02";
		Boolean incidentActive = true;
		Long incidentId = new Long(1);
		List<Translation> translations = Arrays.asList(new Translation(updated_at, "pt_BR", content));
		List<Message> messages = Arrays.asList(new Message(messageId, authorId, heading, content, severity, created_at, updated_at, translations));
		List<Incident> incidents = Arrays.asList(new Incident(incidentId, incidentActive, created_at, messages));
		List<Service> services = Arrays.asList(new Service(serviceName, serviceSlug, status, incidents));
		ShardStatus shardStatus = new ShardStatus(locales, hostname, name, services, slug, region_tag);
		Mockito
	        .when(noxus.getStatusShardData())
	        .thenReturn(shardStatus);
		Assert.assertEquals(noxus.getStatusShardData(), shardStatus);
		Mockito
			.verify(noxus)
			.getStatusShardData();
	}

	@Test
	public void getChallengerLeaguesByQueueTest() {
		String rankedSolo5x5 = "RANKED_SOLO_5x5";
		LeagueListDTO leagueListDTO = new LeagueListDTO("6870131b-2440-3229-993f-42e2f895da3d",
				Arrays.asList(new LeagueItemDTO(false, new Integer(909), "riotApiTest", null, false, false, true, "I", new Integer(1524), new Integer(600), "MPkPwVAqpCmNhXeE3sNsSCR2LqtnpIm6ZLD7HmuIs5WJ")),
				"CHALLENGER",
				"Janna's Defiants",
				"RANKED_SOLO_5x5");
		Mockito
		.when(noxus.getChallengerLeaguesByQueue(rankedSolo5x5))
		.thenReturn(leagueListDTO);
		Assert.assertEquals(leagueListDTO, noxus.getChallengerLeaguesByQueue(rankedSolo5x5));
		Mockito
			.verify(noxus)
			.getChallengerLeaguesByQueue(rankedSolo5x5);
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
			.when(noxus.getEntriesBySummoner(encryptedSummonerId))
			.thenReturn(leagueEntryDTO);
		Assert.assertArrayEquals(leagueEntryDTO, noxus.getEntriesBySummoner(encryptedSummonerId));
		Mockito
			.verify(noxus)
			.getEntriesBySummoner(encryptedSummonerId);
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
	        .when(noxus.getEntriesByQueueTierDivision(queueReq, tierReq, divisionReq))
	        .thenReturn(leagueEntryDTO);
		Assert.assertArrayEquals(leagueEntryDTO, noxus.getEntriesByQueueTierDivision(queueReq, tierReq, divisionReq));
		Mockito
			.verify(noxus)
			.getEntriesByQueueTierDivision(queueReq, tierReq, divisionReq);
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
			.when(noxus.getGrandmasterLeaguesByQueue(rankedSolo5x5))
			.thenReturn(leagueListDTO);
		Assert.assertEquals(leagueListDTO, noxus.getGrandmasterLeaguesByQueue(rankedSolo5x5));
		Mockito
			.verify(noxus)
			.getGrandmasterLeaguesByQueue(rankedSolo5x5);
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
			.when(noxus.getMasterLeaguesByQueue(rankedSolo5x5))
			.thenReturn(leagueListDTO);
		Assert.assertEquals(noxus.getMasterLeaguesByQueue(rankedSolo5x5), leagueListDTO);
		Mockito
			.verify(noxus)
			.getMasterLeaguesByQueue(rankedSolo5x5);
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
			.when(noxus.getLeagueById(leagueId))
			.thenReturn(leagueListDTO);
		Assert.assertEquals(leagueListDTO, noxus.getLeagueById(leagueId));
		Mockito.verify(noxus).getLeagueById(leagueId);
	}

	@Test
	public void getChampionMasteriesTest() {
		String encryptedSummoner = "encryptedSummonerIdTest";
		ChampionMasteryDTO[] championsMasteriesOfUser = new ChampionMasteryDTO[]{new ChampionMasteryDTO(new Long(10), true, new Long(1),
    			new Long("1577847600000"), 20, "summonerIdTest", new Integer(1000000),
    			new Long("100000"), new Integer(1))};
		Mockito
	        .when(noxus.getChampionMasteries(encryptedSummoner))
	        .thenReturn(championsMasteriesOfUser);
		Assert.assertArrayEquals(noxus.getChampionMasteries(encryptedSummoner), championsMasteriesOfUser);
		Mockito
			.verify(noxus)
			.getChampionMasteries(encryptedSummoner);
	}
	
	@Test
	public void getChampionMasteryByIDTest() {
		String encryptedSummonerId = "encryptedSummonerIdTest";
		String championId = "1";
		ChampionMasteryDTO championMastery = new ChampionMasteryDTO(new Long(10), true, new Long(1),
				new Long("1577847600000"), 20, "summonerIdTest", new Integer(1000000),
				new Long("100000"), new Integer(1));
		Mockito
			.when(noxus.getChampionMasteryByID(encryptedSummonerId, championId))
			.thenReturn(championMastery);
		Assert.assertEquals(noxus.getChampionMasteryByID(encryptedSummonerId, championId), championMastery);
		Mockito
			.verify(noxus)
			.getChampionMasteryByID(encryptedSummonerId, championId);
	}

	@Test
	public void getScoresTest() {
		String encryptedSummonerId = "encryptedSummonerIdTest";
		Integer championMasteriesScores = new Integer(27);
		Mockito
	        .when(noxus.getScores(encryptedSummonerId))
	        .thenReturn(championMasteriesScores);
		Assert.assertEquals(championMasteriesScores, noxus.getScores(encryptedSummonerId));
		Mockito
			.verify(noxus)
			.getScores(encryptedSummonerId);
	}
}
