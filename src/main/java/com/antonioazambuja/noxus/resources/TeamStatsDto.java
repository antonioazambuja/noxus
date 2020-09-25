package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class TeamStatsDto {
	@JsonProperty("championId")
	private Integer ChampionId;
	@JsonProperty("pickTurn")
	private Integer PickTurn;

	public TeamStatsDto() {}

	public TeamStatsDto(Integer championId, Integer pickTurn) {
		ChampionId = championId;
		PickTurn = pickTurn;
	}

	public Integer getChampionId() {
		return ChampionId;
	}

	public void setChampionId(Integer championId) {
		ChampionId = championId;
	}

	public Integer getPickTurn() {
		return PickTurn;
	}

	public void setPickTurn(Integer pickTurn) {
		PickTurn = pickTurn;
	}

}
