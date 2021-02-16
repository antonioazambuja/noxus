package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamBansDto {
	@JsonProperty("championId")
	private Integer ChampionId;
	@JsonProperty("pickTurn")
	private Integer PickTurn;

	public TeamBansDto() {}

	public TeamBansDto(Integer championId, Integer pickTurn) {
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
