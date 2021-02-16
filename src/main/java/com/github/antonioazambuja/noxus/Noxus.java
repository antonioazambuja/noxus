package com.github.antonioazambuja.noxus;

import java.util.HashSet;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.github.antonioazambuja.noxus.api.ChampionMasteryV4;
import com.github.antonioazambuja.noxus.api.ChampionV3;
import com.github.antonioazambuja.noxus.api.LeagueV4;
import com.github.antonioazambuja.noxus.api.LolStatusV3;
import com.github.antonioazambuja.noxus.api.MatchV4;
import com.github.antonioazambuja.noxus.api.SpectatorV4;
import com.github.antonioazambuja.noxus.api.SummonerV4;
import com.github.antonioazambuja.noxus.resources.ChampionInfoV3;
import com.github.antonioazambuja.noxus.resources.ChampionMasteryDTO;
import com.github.antonioazambuja.noxus.resources.CurrentGameInfo;
import com.github.antonioazambuja.noxus.resources.FeaturedGame;
import com.github.antonioazambuja.noxus.resources.LeagueEntryDTO;
import com.github.antonioazambuja.noxus.resources.LeagueListDTO;
import com.github.antonioazambuja.noxus.resources.MatchDto;
import com.github.antonioazambuja.noxus.resources.MatchTimelineDto;
import com.github.antonioazambuja.noxus.resources.MatchlistDto;
import com.github.antonioazambuja.noxus.resources.RiotURI;
import com.github.antonioazambuja.noxus.resources.ShardStatus;
import com.github.antonioazambuja.noxus.resources.SummonerDTO;

public class Noxus implements ChampionMasteryV4, ChampionV3, LeagueV4, LolStatusV3, SpectatorV4, SummonerV4, MatchV4 {

	private Config config;

	public Noxus(Config config) {
		this.config = config;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	@Override
	public ChampionMasteryDTO[] getChampionMasteries(String encryptedSummonerId) {
		ResponseEntity<ChampionMasteryDTO[]> championMasteries = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				ChampionMasteryDTO[].class,
				encryptedSummonerId
		);
		return championMasteries.getBody();
	}

	@Override
	public ChampionMasteryDTO getChampionMasteryByID(String encryptedSummonerId, String championId) {
		ResponseEntity<ChampionMasteryDTO> championMastery = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				ChampionMasteryDTO.class,
				encryptedSummonerId,
				championId
		);
		return championMastery.getBody();
	}

	@Override
	public Integer getScores(String encryptedSummonerId) {
		ResponseEntity<Integer> summonerScore = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				Integer.class,
				encryptedSummonerId
		);
		return summonerScore.getBody();
	}

	@Override
	public ChampionInfoV3 getChampionRotation() {
		ResponseEntity<ChampionInfoV3> championInfo = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/platform/v3/champion-rotations",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				ChampionInfoV3.class
		);
		return championInfo.getBody();
	}

	@Override
	public LeagueListDTO getChallengerLeaguesByQueue(String queueName) {
		ResponseEntity<LeagueListDTO> leagueListDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/league/v4/challengerleagues/by-queue/{queueName}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				LeagueListDTO.class,
				queueName
		);
		return leagueListDTO.getBody();
	}

	@Override
	public LeagueEntryDTO[] getEntriesBySummoner(String encryptedSummonerId) {
		ResponseEntity<LeagueEntryDTO[]> leagueEntryDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/league/v4/entries/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				LeagueEntryDTO[].class,
				encryptedSummonerId
		);
		return leagueEntryDTO.getBody();
	}

	@Override
	public LeagueEntryDTO[] getEntriesByQueueTierDivision(String queue, String tier, String division) {
		ResponseEntity<LeagueEntryDTO[]> leagueEntryDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/league/v4/entries/{queue}/{tier}/{division}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				LeagueEntryDTO[].class,
				queue,
				tier,
				division
		);
		return leagueEntryDTO.getBody();
	}

	@Override
	public LeagueListDTO getGrandmasterLeaguesByQueue(String queue) {
		ResponseEntity<LeagueListDTO> leagueEntryDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/league/v4/grandmasterleagues/by-queue/{queue}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				LeagueListDTO.class,
				queue
		);
		return leagueEntryDTO.getBody();
	}

	@Override
	public LeagueListDTO getLeagueById(String leagueId) {
		ResponseEntity<LeagueListDTO> leagueEntryDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/league/v4/leagues/{leagueId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				LeagueListDTO.class,
				leagueId
		);
		return leagueEntryDTO.getBody();
	}

	@Override
	public LeagueListDTO getMasterLeaguesByQueue(String queue) {
		ResponseEntity<LeagueListDTO> leagueEntryDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/league/v4/masterleagues/by-queue/{queue}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				LeagueListDTO.class,
				queue
		);
		return leagueEntryDTO.getBody();
	}

	@Override
	public ShardStatus getStatusShardData() {
		ResponseEntity<ShardStatus> shardStatus = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/status/v3/shard-data",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				ShardStatus.class
		);
		return shardStatus.getBody();
	}

	@Override
	public FeaturedGame getFeaturedGames() {
		ResponseEntity<FeaturedGame> featuredGames = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/spectator/v4/featured-games",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				FeaturedGame.class
				);
		return featuredGames.getBody();
	}

	@Override
	public CurrentGameInfo getActiveGamesBySummoner(String encryptedSummonerId) {
		ResponseEntity<CurrentGameInfo> currentGameInfo = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/spectator/v4/active-games/by-summoner/{encryptedSummonerId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				CurrentGameInfo.class,
				encryptedSummonerId
		);
		return currentGameInfo.getBody();
	}

	@Override
	public SummonerDTO getSummonerByEncryptedAccountId(String encryptedAccountId) {
		ResponseEntity<SummonerDTO> summonerDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/summoner/v4/summoners/by-account/{encryptedAccountId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				SummonerDTO.class,
				encryptedAccountId
		);
		return summonerDTO.getBody();
	}

	@Override
	public SummonerDTO getSummonerByName(String summonerName) {
		ResponseEntity<SummonerDTO> summonerDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/summoner/v4/summoners/by-name/{summonerName}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				SummonerDTO.class,
				summonerName
		);
		return summonerDTO.getBody();
	}

	@Override
	public SummonerDTO getSummonerByPuuid(String encryptedPuuid) {
		ResponseEntity<SummonerDTO> summonerDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/summoner/v4/summoners/by-puuid/{encryptedPuuid}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				SummonerDTO.class,
				encryptedPuuid
		);
		return summonerDTO.getBody();
	}

	@Override
	public SummonerDTO getSummonerById(String encryptedSummonerId) {
		ResponseEntity<SummonerDTO> summonerDTO = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/summoner/v4/summoners/{encryptedSummonerId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				SummonerDTO.class,
				encryptedSummonerId
		);
		return summonerDTO.getBody();
	}

	@Override
	public MatchDto getMatchById(Long matchId) {
		ResponseEntity<MatchDto> matchDto = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/match/v4/matches/{matchId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				MatchDto.class,
				matchId
		);
		return matchDto.getBody();
	}

	@Override
	public MatchTimelineDto getTimelineMatchById(String matchId) {
		ResponseEntity<MatchTimelineDto> matchDto = this.getConfig().getRestTemplate().exchange(
				"https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/match/v4/timelines/by-match/{matchId}",
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				MatchTimelineDto.class,
				matchId
		);
		return matchDto.getBody();
	}

	@Override
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, Long endTime, Long beginTime, Integer endIndex,
			Integer beginIndex) {
		ResponseEntity<MatchlistDto> matchlistDto = this.getConfig().getRestTemplate().exchange(
				new RiotURI("https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
					.setStringQueryParam("endTime", endTime.toString())
					.setStringQueryParam("beginTime", beginTime.toString())
					.setStringQueryParam("endIndex", endIndex.toString())
					.setStringQueryParam("beginIndex", beginIndex.toString())
					.getRiotURL()
					.toUriString(),
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				MatchlistDto.class,
				encryptedAccountId
		);
		return matchlistDto.getBody();
	}

	@Override
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, Long endTime,
			Long beginTime, Integer endIndex, Integer beginIndex) {
		ResponseEntity<MatchlistDto> matchlistDto = this.getConfig().getRestTemplate().exchange(
				new RiotURI("https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
					.setStringQueryParam("endTime", endTime.toString())
					.setStringQueryParam("beginTime", beginTime.toString())
					.setStringQueryParam("endIndex", endIndex.toString())
					.setStringQueryParam("beginIndex", beginIndex.toString())
					.getRiotURL()
					.toUriString(),
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				MatchlistDto.class,
				encryptedAccountId
		);
		return matchlistDto.getBody();
	}

	@Override
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion,
			HashSet<Integer> queue, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex) {
		ResponseEntity<MatchlistDto> matchlistDto = this.getConfig().getRestTemplate().exchange(
				new RiotURI("https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
					.setIterableQueryParam("champion", champion)
					.setIterableQueryParam("queue", queue)
					.setStringQueryParam("endTime", endTime.toString())
					.setStringQueryParam("beginTime", beginTime.toString())
					.setStringQueryParam("endIndex", endIndex.toString())
					.setStringQueryParam("beginIndex", beginIndex.toString())
					.getRiotURL()
					.toUriString(),
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				MatchlistDto.class,
				encryptedAccountId
		);
		return matchlistDto.getBody();
	}

	@Override
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion,
			HashSet<Integer> queue, HashSet<Integer> season, Long endTime, Long beginTime, Integer endIndex,
			Integer beginIndex) {
		ResponseEntity<MatchlistDto> matchlistDto = this.getConfig().getRestTemplate().exchange(
				new RiotURI("https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
					.setIterableQueryParam("champion", champion)
					.setIterableQueryParam("queue", queue)
					.setIterableQueryParam("season", season)
					.setStringQueryParam("endTime", endTime.toString())
					.setStringQueryParam("beginTime", beginTime.toString())
					.setStringQueryParam("endIndex", endIndex.toString())
					.setStringQueryParam("beginIndex", beginIndex.toString())
					.getRiotURL()
					.toUriString(),
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				MatchlistDto.class,
				encryptedAccountId
		);
		return matchlistDto.getBody();
	}

	@Override
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, Integer endIndex, Integer beginIndex) {
		ResponseEntity<MatchlistDto> matchlistDto = this.getConfig().getRestTemplate().exchange(
				new RiotURI("https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
					.setStringQueryParam("endIndex", endIndex.toString())
					.setStringQueryParam("beginIndex", beginIndex.toString())
					.getRiotURL()
					.toUriString(),
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				MatchlistDto.class,
				encryptedAccountId
		);
		return matchlistDto.getBody();
	}

	@Override
	public MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, Integer endIndex,
			Integer beginIndex) {
		ResponseEntity<MatchlistDto> matchlistDto = this.getConfig().getRestTemplate().exchange(
				new RiotURI("https://" + this.getConfig().getRegion().getApiRegionEndpoint() + "/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
					.setStringQueryParam("endIndex", endIndex.toString())
					.setStringQueryParam("beginIndex", beginIndex.toString())
					.setIterableQueryParam("champion", champion)
					.getRiotURL()
					.toUriString(),
				HttpMethod.GET,
				this.getConfig().getHttpEntity(),
				MatchlistDto.class,
				encryptedAccountId
		);
		return matchlistDto.getBody();
	}
}
