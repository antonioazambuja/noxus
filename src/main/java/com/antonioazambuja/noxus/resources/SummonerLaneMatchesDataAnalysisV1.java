package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class SummonerLaneMatchesDataAnalysisV1 {
	@JsonProperty("lane")
	private String Lane;
	@JsonProperty("winRate")
	private Double WinRate;
	@JsonProperty("matches")
	private List<MatchDto> Matches;
	@JsonProperty("summoner")
	private SummonerDTO Summoner;

	public SummonerLaneMatchesDataAnalysisV1(String lane, Double winRate, List<MatchDto> matches, SummonerDTO summoner) {
		Lane = lane;
		Matches = matches;
		WinRate = winRate;
		Summoner = summoner;
	}

	public SummonerLaneMatchesDataAnalysisV1() { }

	public String getLane() {
		return Lane;
	}

	public void setLane(String lane) {
		Lane = lane;
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
