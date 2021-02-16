package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchReferenceDto {
	@JsonProperty("gameId")
	private Long GameId;
	@JsonProperty("role")
	private String Role;
	@JsonProperty("season")
	private Integer Season;
	@JsonProperty("platformId")
	private String PlatformId;
	@JsonProperty("champion")
	private Integer Champion;
	@JsonProperty("queue")
	private Integer Queue;
	@JsonProperty("lane")
	private String Lane;
	@JsonProperty("timestamp")
	private Long Timestamp;

	public MatchReferenceDto() {}

	public MatchReferenceDto(Long gameId, String role, Integer season, String platformId, Integer champion,
			Integer queue, String lane, Long timestamp) {
		GameId = gameId;
		Role = role;
		Season = season;
		PlatformId = platformId;
		Champion = champion;
		Queue = queue;
		Lane = lane;
		Timestamp = timestamp;
	}

	public Long getGameId() {
		return GameId;
	}

	public void setGameId(Long gameId) {
		GameId = gameId;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Integer getSeason() {
		return Season;
	}

	public void setSeason(Integer season) {
		Season = season;
	}

	public String getPlatformId() {
		return PlatformId;
	}

	public void setPlatformId(String platformId) {
		PlatformId = platformId;
	}

	public Integer getChampion() {
		return Champion;
	}

	public void setChampion(Integer champion) {
		Champion = champion;
	}

	public Integer getQueue() {
		return Queue;
	}

	public void setQueue(Integer queue) {
		Queue = queue;
	}

	public String getLane() {
		return Lane;
	}

	public void setLane(String lane) {
		Lane = lane;
	}

	public Long getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Long timestamp) {
		Timestamp = timestamp;
	}

}
