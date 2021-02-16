package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MasteryDto {
	@JsonProperty("rank")
	private Integer Rank;
	@JsonProperty("masteryId")
	private Integer MasteryId;

	public MasteryDto() {}

	public MasteryDto(Integer rank, Integer masteryId) {
		Rank = rank;
		MasteryId = masteryId;
	}

	public Integer getRank() {
		return Rank;
	}

	public void setRank(Integer rank) {
		Rank = rank;
	}

	public Integer getMasteryId() {
		return MasteryId;
	}

	public void setMasteryId(Integer masteryId) {
		MasteryId = masteryId;
	}

}
