package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class LeagueItemDTO {
	@JsonProperty("freshBlood")
	private Boolean FreshBlood;
	@JsonProperty("wins")
	private Integer Wins;
	@JsonProperty("summonerName")
	private String SummonerName;
	@JsonProperty("miniSeries")
	private MiniSeriesDTO MiniSeries;
	@JsonProperty("inactive")
	private Boolean Inactive;
	@JsonProperty("veteran")
	private Boolean Veteran;
	@JsonProperty("hotStreak")
	private Boolean HotStreak;
	@JsonProperty("rank")
	private String Rank;
	@JsonProperty("leaguePoints")
	private Integer LeaguePoints;
	@JsonProperty("losses")
	private Integer Losses;
	@JsonProperty("summonerId")
	private String SummonerId;

	public LeagueItemDTO(Boolean freshBlood, Integer wins, String summonerName, MiniSeriesDTO miniSeries,
			Boolean inactive, Boolean veteran, Boolean hotStreak, String rank, Integer leaguePoints, Integer losses,
			String summonerID) {
		FreshBlood = freshBlood;
		Wins = wins;
		SummonerName = summonerName;
		MiniSeries = miniSeries;
		Inactive = inactive;
		Veteran = veteran;
		HotStreak = hotStreak;
		Rank = rank;
		LeaguePoints = leaguePoints;
		Losses = losses;
		SummonerId = summonerID;
	}

	public LeagueItemDTO() {}

	public Boolean getFreshBlood() {
		return FreshBlood;
	}

	public void setFreshBlood(Boolean freshBlood) {
		FreshBlood = freshBlood;
	}

	public Integer getWins() {
		return Wins;
	}

	public void setWins(Integer wins) {
		Wins = wins;
	}

	public String getSummonerName() {
		return SummonerName;
	}

	public void setSummonerName(String summonerName) {
		SummonerName = summonerName;
	}

	public MiniSeriesDTO getMiniSeries() {
		return MiniSeries;
	}

	public void setMiniSeries(MiniSeriesDTO miniSeries) {
		MiniSeries = miniSeries;
	}

	public Boolean getInactive() {
		return Inactive;
	}

	public void setInactive(Boolean inactive) {
		Inactive = inactive;
	}

	public Boolean getVeteran() {
		return Veteran;
	}

	public void setVeteran(Boolean veteran) {
		Veteran = veteran;
	}

	public Boolean getHotStreak() {
		return HotStreak;
	}

	public void setHotStreak(Boolean hotStreak) {
		HotStreak = hotStreak;
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

	public Integer getLosses() {
		return Losses;
	}

	public void setLosses(Integer losses) {
		Losses = losses;
	}

	public String getSummonerId() {
		return SummonerId;
	}

	public void setSummonerId(String summonerID) {
		SummonerId = summonerID;
	}
}
