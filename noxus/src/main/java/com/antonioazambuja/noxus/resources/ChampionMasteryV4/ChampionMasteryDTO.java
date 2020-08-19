package com.antonioazambuja.noxus.resources.ChampionMasteryV4;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class ChampionMasteryDTO {
	@JsonProperty("championPointsUntilNextLevel")
	private Long ChampionPointsUntilNextLevel;
	@JsonProperty("chestGranted")
	private Boolean ChestGranted;
	@JsonProperty("championId")
	private Long ChampionId;
	@JsonProperty("lastPlayTime")
	private Long LastPlayTime;
	@JsonProperty("championLevel")
	private Integer ChampionLevel;
	@JsonProperty("summonerId")
	private String SummonerId;
	@JsonProperty("championPoints")
	private Integer ChampionPoints;
	@JsonProperty("championPointsSinceLastLevel")
	private Long ChampionPointsSinceLastLevel;
	@JsonProperty("tokensEarned")
	private Integer TokensEarned;

	public Long getChampionPointsUntilNextLevel() {
		return ChampionPointsUntilNextLevel;
	}

	public void setChampionPointsUntilNextLevel(Long championPointsUntilNextLevel) {
		ChampionPointsUntilNextLevel = championPointsUntilNextLevel;
	}
	public Boolean getChestGranted() {
		return ChestGranted;
	}
	public void setChestGranted(Boolean chestGranted) {
		ChestGranted = chestGranted;
	}
	public Long getChampionId() {
		return ChampionId;
	}
	public void setChampionId(Long championId) {
		ChampionId = championId;
	}
	public Long getLastPlayTime() {
		return LastPlayTime;
	}
	public void setLastPlayTime(Long lastPlayTime) {
		LastPlayTime = lastPlayTime;
	}
	public Integer getChampionLevel() {
		return ChampionLevel;
	}
	public void setChampionLevel(Integer championLevel) {
		ChampionLevel = championLevel;
	}
	public String getSummonerId() {
		return SummonerId;
	}
	public void setSummonerId(String summonerId) {
		SummonerId = summonerId;
	}
	public Integer getChampionPoints() {
		return ChampionPoints;
	}
	public void setChampionPoints(Integer championPoints) {
		ChampionPoints = championPoints;
	}
	public Long getChampionPointsSinceLastLevel() {
		return ChampionPointsSinceLastLevel;
	}
	public void setChampionPointsSinceLastLevel(Long championPointsSinceLastLevel) {
		ChampionPointsSinceLastLevel = championPointsSinceLastLevel;
	}
	public Integer getTokensEarned() {
		return TokensEarned;
	}
	public void setTokensEarned(Integer tokensEarned) {
		TokensEarned = tokensEarned;
	}
	
}
