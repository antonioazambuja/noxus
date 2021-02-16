package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuneDto {
	@JsonProperty("runeId")
	private Integer RuneId;
	@JsonProperty("rank")
	private Integer Rank;

	public RuneDto() {}

	public RuneDto(Integer runeId, Integer rank) {
		RuneId = runeId;
		Rank = rank;
	}

	public Integer getRuneId() {
		return RuneId;
	}

	public void setRuneId(Integer runeId) {
		RuneId = runeId;
	}

	public Integer getRank() {
		return Rank;
	}

	public void setRank(Integer rank) {
		Rank = rank;
	}

}
