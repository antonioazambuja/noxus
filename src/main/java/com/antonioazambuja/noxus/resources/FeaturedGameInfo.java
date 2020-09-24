package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class FeaturedGameInfo {
	@JsonProperty("gameMode")
	private String GameMode;
	@JsonProperty("gameLength")
	private Long GameLength;
	@JsonProperty("mapId")
	private Long MapId;
	@JsonProperty("gameType")
	private String GameType;
	@JsonProperty("bannedChampions")
	private List<BannedChampion> BannedChampions;
	@JsonProperty("gameId")
	private Long GameId;
	@JsonProperty("observers")
	private Observer Observers;
	@JsonProperty("gameQueueConfigId")
	private Long GameQueueConfigId;
	@JsonProperty("gameStartTime")
	private Long GameStartTime;
	@JsonProperty("participants")
	private List<Participant> Participants;
	@JsonProperty("platformId")
	private String PlatformId;

	public FeaturedGameInfo() {}

	public FeaturedGameInfo(String gameMode, Long gameLength, Long mapId, String gameType,
			List<BannedChampion> bannedChampions, Long gameId, Observer observers, Long gameQueueConfigId,
			Long gameStartTime, List<Participant> participants, String platformId) {
		GameMode = gameMode;
		GameLength = gameLength;
		MapId = mapId;
		GameType = gameType;
		BannedChampions = bannedChampions;
		GameId = gameId;
		Observers = observers;
		GameQueueConfigId = gameQueueConfigId;
		GameStartTime = gameStartTime;
		Participants = participants;
		PlatformId = platformId;
	}

	public String getGameMode() {
		return GameMode;
	}

	public void setGameMode(String gameMode) {
		GameMode = gameMode;
	}

	public Long getGameLength() {
		return GameLength;
	}

	public void setGameLength(Long gameLength) {
		GameLength = gameLength;
	}

	public Long getMapId() {
		return MapId;
	}

	public void setMapId(Long mapId) {
		MapId = mapId;
	}

	public String getGameType() {
		return GameType;
	}

	public void setGameType(String gameType) {
		GameType = gameType;
	}

	public List<BannedChampion> getBannedChampions() {
		return BannedChampions;
	}

	public void setBannedChampions(List<BannedChampion> bannedChampions) {
		BannedChampions = bannedChampions;
	}

	public Long getGameId() {
		return GameId;
	}

	public void setGameId(Long gameId) {
		GameId = gameId;
	}

	public Observer getObservers() {
		return Observers;
	}

	public void setObservers(Observer observers) {
		Observers = observers;
	}

	public Long getGameQueueConfigId() {
		return GameQueueConfigId;
	}

	public void setGameQueueConfigId(Long gameQueueConfigId) {
		GameQueueConfigId = gameQueueConfigId;
	}

	public Long getGameStartTime() {
		return GameStartTime;
	}

	public void setGameStartTime(Long gameStartTime) {
		GameStartTime = gameStartTime;
	}

	public List<Participant> getParticipants() {
		return Participants;
	}

	public void setParticipants(List<Participant> participants) {
		Participants = participants;
	}

	public String getPlatformId() {
		return PlatformId;
	}

	public void setPlatformId(String platformId) {
		PlatformId = platformId;
	}
}
