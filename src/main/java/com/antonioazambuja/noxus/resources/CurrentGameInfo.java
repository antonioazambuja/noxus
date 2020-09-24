package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class CurrentGameInfo {
	@JsonProperty("gameId")
	private Long GameId;
	@JsonProperty("gameType")
	private String GameType;
	@JsonProperty("gameStartTime")
	private Long GameStartTime;
	@JsonProperty("mapId")
	private Long MapId;
	@JsonProperty("gameLength")
	private Long GameLength;
	@JsonProperty("platformId")
	private String PlatformId;
	@JsonProperty("gameMode")
	private String GameMode;
	@JsonProperty("bannedChampions")
	private List<BannedChampion> BannedChampions;
	@JsonProperty("gameQueueConfigId")
	private Long GameQueueConfigId;
	@JsonProperty("observers")
	private Observer Observers;
	@JsonProperty("participants")
	private List<Participant> Participants;

	public CurrentGameInfo() {}

	public CurrentGameInfo(Long gameId, String gameType, Long gameStartTime, Long mapId, Long gameLength,
			String platformId, String gameMode, List<BannedChampion> bannedChampions, Long gameQueueConfigId,
			Observer observers, List<Participant> participants) {
		GameId = gameId;
		GameType = gameType;
		GameStartTime = gameStartTime;
		MapId = mapId;
		GameLength = gameLength;
		PlatformId = platformId;
		GameMode = gameMode;
		BannedChampions = bannedChampions;
		GameQueueConfigId = gameQueueConfigId;
		Observers = observers;
		Participants = participants;
	}

	public Long getGameId() {
		return GameId;
	}

	public void setGameId(Long gameId) {
		GameId = gameId;
	}

	public String getGameType() {
		return GameType;
	}

	public void setGameType(String gameType) {
		GameType = gameType;
	}

	public Long getGameStartTime() {
		return GameStartTime;
	}

	public void setGameStartTime(Long gameStartTime) {
		GameStartTime = gameStartTime;
	}

	public Long getMapId() {
		return MapId;
	}

	public void setMapId(Long mapId) {
		MapId = mapId;
	}

	public Long getGameLength() {
		return GameLength;
	}

	public void setGameLength(Long gameLength) {
		GameLength = gameLength;
	}

	public String getPlatformId() {
		return PlatformId;
	}

	public void setPlatformId(String platformId) {
		PlatformId = platformId;
	}

	public String getGameMode() {
		return GameMode;
	}

	public void setGameMode(String gameMode) {
		GameMode = gameMode;
	}

	public List<BannedChampion> getBannedChampions() {
		return BannedChampions;
	}

	public void setBannedChampions(List<BannedChampion> bannedChampions) {
		BannedChampions = bannedChampions;
	}

	public Long getGameQueueConfigId() {
		return GameQueueConfigId;
	}

	public void setGameQueueConfigId(Long gameQueueConfigId) {
		GameQueueConfigId = gameQueueConfigId;
	}

	public Observer getObservers() {
		return Observers;
	}

	public void setObservers(Observer observers) {
		Observers = observers;
	}

	public List<Participant> getParticipants() {
		return Participants;
	}

	public void setParticipants(List<Participant> participants) {
		Participants = participants;
	}
}
