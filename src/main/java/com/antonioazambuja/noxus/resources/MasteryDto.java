package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
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
