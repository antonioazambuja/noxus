package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class SummonerDataChampionV1 {
	@JsonProperty("champion")
	private Integer Champion;
	@JsonProperty("winRate")
	private Double WinRate;
	@JsonProperty("matches")
	private List<MatchDto> Matches;
	@JsonProperty("summoner")
	private SummonerDTO Summoner;

	public SummonerDataChampionV1(Integer champion, Double winRate, List<MatchDto> matches, SummonerDTO summoner) {
		Champion = champion;
		Matches = matches;
		WinRate = winRate;
		Summoner = summoner;
	}

	public SummonerDataChampionV1() { }

	public Integer getChampion() {
		return Champion;
	}

	public void setChampion(Integer champion) {
		Champion = champion;
	}

	public Double getWinRate() {
		return WinRate;
	}

	public void setWinRate(Double winRate) {
		WinRate = winRate;
	}

	public List<MatchDto> getMatches() {
		return Matches;
	}

	public void setMatches(List<MatchDto> matches) {
		Matches = matches;
	}

	public SummonerDTO getSummoner() {
		return Summoner;
	}

	public void setSummoner(SummonerDTO summoner) {
		Summoner = summoner;
	}

}
