package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniSeriesDTO {
	@JsonProperty("losses")
	private Integer Losses;
	@JsonProperty("wins")
	private Integer Wins;
	@JsonProperty("progress")
	private String Progress;
	@JsonProperty("target")
	private Integer Target;

	public MiniSeriesDTO(Integer losses, Integer wins, String progress, Integer target) {
		this.Losses = losses;
		this.Wins = wins;
		this.Progress = progress;
		this.Target = target;
	}

	public MiniSeriesDTO() {}

	public Integer getLosses() {
		return Losses;
	}
	public void setLosses(Integer losses) {
		Losses = losses;
	}
	public Integer getWins() {
		return Wins;
	}
	public void setWins(Integer wins) {
		Wins = wins;
	}
	public String getProgress() {
		return Progress;
	}
	public void setProgress(String progress) {
		Progress = progress;
	}
	public Integer getTarget() {
		return Target;
	}
	public void setTarget(Integer target) {
		Target = target;
	}


}
