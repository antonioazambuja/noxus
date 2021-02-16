package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChampionInfoV3 {
	@JsonProperty("maxNewPlayerLevel")
	private Integer MaxNewPlayerLevel;
	@JsonProperty("freeChampionIdsForNewPlayers")
	private List<Integer> FreeChampionIdsForNewPlayers;
	@JsonProperty("freeChampionIds")
	private List<Integer> FreeChampionIds;

	public ChampionInfoV3(Integer maxNewPlayerLevel, List<Integer> freeChampionIdsForNewPlayers,
			List<Integer> freeChampionIds) {
		MaxNewPlayerLevel = maxNewPlayerLevel;
		FreeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
		FreeChampionIds = freeChampionIds;
	}

	public ChampionInfoV3() {}

	public Integer getMaxNewPlayerLevel() {
		return MaxNewPlayerLevel;
	}
	public void setMaxNewPlayerLevel(Integer maxNewPlayerLevel) {
		MaxNewPlayerLevel = maxNewPlayerLevel;
	}
	public List<Integer> getFreeChampionIdsForNewPlayers() {
		return FreeChampionIdsForNewPlayers;
	}
	public void setFreeChampionIdsForNewPlayers(List<Integer> freeChampionIdsForNewPlayers) {
		FreeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
	}
	public List<Integer> getFreeChampionIds() {
		return FreeChampionIds;
	}
	public void setFreeChampionIds(List<Integer> freeChampionIds) {
		FreeChampionIds = freeChampionIds;
	}
}
