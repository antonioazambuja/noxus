package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchlistDto {
	@JsonProperty("startIndex")
	private Integer StartIndex;
	@JsonProperty("totalGames")
	private Integer TotalGames;
	@JsonProperty("endIndex")
	private Integer EndIndex;
	@JsonProperty("matches")
	private List<MatchReferenceDto> Matches;

	public MatchlistDto() {}

	public MatchlistDto(Integer startIndex, Integer totalGames, Integer endIndex, List<MatchReferenceDto> matches) {
		StartIndex = startIndex;
		TotalGames = totalGames;
		EndIndex = endIndex;
		Matches = matches;
	}

	public Integer getStartIndex() {
		return StartIndex;
	}

	public void setStartIndex(Integer startIndex) {
		StartIndex = startIndex;
	}

	public Integer getTotalGames() {
		return TotalGames;
	}

	public void setTotalGames(Integer totalGames) {
		TotalGames = totalGames;
	}

	public Integer getEndIndex() {
		return EndIndex;
	}

	public void setEndIndex(Integer endIndex) {
		EndIndex = endIndex;
	}

	public List<MatchReferenceDto> getMatches() {
		return Matches;
	}

	public void setMatches(List<MatchReferenceDto> matches) {
		Matches = matches;
	}

}