package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchPositionDto {
	@JsonProperty("x")
	private Integer X;
	@JsonProperty("y")
	private Integer Y;

	public MatchPositionDto() {}

	public MatchPositionDto(Integer x, Integer y) {
		X = x;
		Y = y;
	}

	public Integer getX() {
		return X;
	}

	public void setX(Integer x) {
		X = x;
	}

	public Integer getY() {
		return Y;
	}

	public void setY(Integer y) {
		Y = y;
	}

}
