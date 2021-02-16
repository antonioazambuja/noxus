package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchDto {
	@JsonProperty("gameId")
	private Long GameId;
	@JsonProperty("participantIdentities")
	private List<ParticipantIdentityDto> ParticipantIdentities;
	@JsonProperty("queueId")
	private Integer QueueId;
	@JsonProperty("gameType")
	private String GameType;
	@JsonProperty("gameDuration")
	private Long GameDuration;
	@JsonProperty("teams")
	private List<TeamStatsDto> Teams;
	@JsonProperty("platformId")
	private String PlatformId;
	@JsonProperty("gameCreation")
	private Long GameCreation;
	@JsonProperty("seasonId")
	private Integer SeasonId;
	@JsonProperty("gameVersion")
	private String GameVersion;
	@JsonProperty("mapId")
	private Integer MapId;
	@JsonProperty("gameMode")
	private String GameMode;
	@JsonProperty("participants")
	private List<ParticipantDto> Participants;

	public MatchDto() {}

	public MatchDto(Long gameId, List<ParticipantIdentityDto> participantIdentities, Integer queueId, String gameType,
			Long gameDuration, List<TeamStatsDto> teams, String platformId, Long gameCreation, Integer seasonId,
			String gameVersion, Integer mapId, String gameMode, List<ParticipantDto> participants) {
		GameId = gameId;
		ParticipantIdentities = participantIdentities;
		QueueId = queueId;
		GameType = gameType;
		GameDuration = gameDuration;
		Teams = teams;
		PlatformId = platformId;
		GameCreation = gameCreation;
		SeasonId = seasonId;
		GameVersion = gameVersion;
		MapId = mapId;
		GameMode = gameMode;
		Participants = participants;
	}

	public Long getGameId() {
		return GameId;
	}

	public void setGameId(Long gameId) {
		GameId = gameId;
	}

	public List<ParticipantIdentityDto> getParticipantIdentities() {
		return ParticipantIdentities;
	}

	public void setParticipantIdentities(List<ParticipantIdentityDto> participantIdentities) {
		ParticipantIdentities = participantIdentities;
	}

	public Integer getQueueId() {
		return QueueId;
	}

	public void setQueueId(Integer queueId) {
		QueueId = queueId;
	}

	public String getGameType() {
		return GameType;
	}

	public void setGameType(String gameType) {
		GameType = gameType;
	}

	public Long getGameDuration() {
		return GameDuration;
	}

	public void setGameDuration(Long gameDuration) {
		GameDuration = gameDuration;
	}

	public List<TeamStatsDto> getTeams() {
		return Teams;
	}

	public void setTeams(List<TeamStatsDto> teams) {
		Teams = teams;
	}

	public String getPlatformId() {
		return PlatformId;
	}

	public void setPlatformId(String platformId) {
		PlatformId = platformId;
	}

	public Long getGameCreation() {
		return GameCreation;
	}

	public void setGameCreation(Long gameCreation) {
		GameCreation = gameCreation;
	}

	public Integer getSeasonId() {
		return SeasonId;
	}

	public void setSeasonId(Integer seasonId) {
		SeasonId = seasonId;
	}

	public String getGameVersion() {
		return GameVersion;
	}

	public void setGameVersion(String gameVersion) {
		GameVersion = gameVersion;
	}

	public Integer getMapId() {
		return MapId;
	}

	public void setMapId(Integer mapId) {
		MapId = mapId;
	}

	public String getGameMode() {
		return GameMode;
	}

	public void setGameMode(String gameMode) {
		GameMode = gameMode;
	}

	public List<ParticipantDto> getParticipants() {
		return Participants;
	}

	public void setParticipants(List<ParticipantDto> participants) {
		Participants = participants;
	}

}
