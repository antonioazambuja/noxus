package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
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
