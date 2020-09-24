package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class BannedChampion {
	@JsonProperty("pickTurn")
	private Integer PickTurn;
	@JsonProperty("championId")
	private Long ChampionId;
	@JsonProperty("teamId")
	private Long TeamId;

	public BannedChampion() {}

	public BannedChampion(Integer pickTurn, Long championId, Long teamId) {
		PickTurn = pickTurn;
		ChampionId = championId;
		TeamId = teamId;
	}

	public Integer getPickTurn() {
		return PickTurn;
	}
	public void setPickTurn(Integer pickTurn) {
		PickTurn = pickTurn;
	}
	public Long getChampionId() {
		return ChampionId;
	}
	public void setChampionId(Long championId) {
		ChampionId = championId;
	}
	public Long getTeamId() {
		return TeamId;
	}
	public void setTeamId(Long teamId) {
		TeamId = teamId;
	}
}
