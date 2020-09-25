package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
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
