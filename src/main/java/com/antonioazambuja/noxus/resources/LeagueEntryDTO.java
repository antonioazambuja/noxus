package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class LeagueEntryDTO {
	@JsonProperty("leagueId")
	private String LeagueId;
	@JsonProperty("summonerId")
	private String SummonerId;
	@JsonProperty("summonerName")
	private String SummonerName;
	@JsonProperty("queueType")
	private String QueueType;
	@JsonProperty("tier")
	private String Tier;
	@JsonProperty("rank")
	private String Rank;
	@JsonProperty("leaguePoints")
	private Integer LeaguePoints;
	@JsonProperty("wins")
	private Integer Wins;
	@JsonProperty("losses")
	private Integer Losses;
	@JsonProperty("hotStreak")
	private Boolean HotStreak;
	@JsonProperty("veteran")
	private Boolean Veteran;
	@JsonProperty("freshBlood")
	private Boolean FreshBlood;
	@JsonProperty("inactive")
	private Boolean Inactive;
	@JsonProperty("miniSeries")
	private MiniSeriesDTO MiniSeries;

	public LeagueEntryDTO(String leagueId, String summonerId, String summonerName, String queueType, String tier,
			String rank, Integer leaguePoints, Integer wins, Integer losses, Boolean hotStreak, Boolean veteran,
			Boolean freshBlood, Boolean inactive, MiniSeriesDTO miniSeries) {
		LeagueId = leagueId;
		SummonerId = summonerId;
		SummonerName = summonerName;
		QueueType = queueType;
		Tier = tier;
		Rank = rank;
		LeaguePoints = leaguePoints;
		Wins = wins;
		Losses = losses;
		HotStreak = hotStreak;
		Veteran = veteran;
		FreshBlood = freshBlood;
		Inactive = inactive;
		MiniSeries = miniSeries;
	}

	public LeagueEntryDTO() {}

	public String getLeagueId() {
		return LeagueId;
	}

	public void setLeagueId(String leagueId) {
		LeagueId = leagueId;
	}

	public String getSummonerId() {
		return SummonerId;
	}

	public void setSummonerId(String summonerId) {
		SummonerId = summonerId;
	}

	public String getSummonerName() {
		return SummonerName;
	}

	public void setSummonerName(String summonerName) {
		SummonerName = summonerName;
	}

	public String getQueueType() {
		return QueueType;
	}

	public void setQueueType(String queueType) {
		QueueType = queueType;
	}

	public String getTier() {
		return Tier;
	}

	public void setTier(String tier) {
		Tier = tier;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		Rank = rank;
	}

	public Integer getLeaguePoints() {
		return LeaguePoints;
	}

	public void setLeaguePoints(Integer leaguePoints) {
		LeaguePoints = leaguePoints;
	}

	public Integer getWins() {
		return Wins;
	}

	public void setWins(Integer wins) {
		Wins = wins;
	}

	public Integer getLosses() {
		return Losses;
	}

	public void setLosses(Integer losses) {
		Losses = losses;
	}

	public Boolean getHotStreak() {
		return HotStreak;
	}

	public void setBotStreak(Boolean hotStreak) {
		HotStreak = hotStreak;
	}

	public Boolean getVeteran() {
		return Veteran;
	}

	public void setVeteran(Boolean veteran) {
		Veteran = veteran;
	}

	public Boolean getFreshBlood() {
		return FreshBlood;
	}

	public void setFreshBlood(Boolean freshBlood) {
		FreshBlood = freshBlood;
	}

	public Boolean getInactive() {
		return Inactive;
	}

	public void setInactive(Boolean inactive) {
		Inactive = inactive;
	}

	public MiniSeriesDTO getMiniSeries() {
		return MiniSeries;
	}

	public void setMiniSeries(MiniSeriesDTO miniSeries) {
		MiniSeries = miniSeries;
	}

}
