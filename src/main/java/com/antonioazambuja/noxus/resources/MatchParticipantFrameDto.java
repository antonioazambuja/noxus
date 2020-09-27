package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class MatchParticipantFrameDto {
	@JsonProperty("participantId")
	private Integer ParticipantId;
	@JsonProperty("minionsKilled")
	private Integer MinionsKilled;
	@JsonProperty("teamScore")
	private Integer TeamScore;
	@JsonProperty("dominionScore")
	private Integer DominionScore;
	@JsonProperty("totalGold")
	private Integer TotalGold;
	@JsonProperty("level")
	private Integer Level;
	@JsonProperty("xp")
	private Integer Xp;
	@JsonProperty("currentGold")
	private Integer CurrentGold;
	@JsonProperty("position")
	private MatchPositionDto Position;
	@JsonProperty("jungleMinionsKilled")
	private Integer JungleMinionsKilled;

	public MatchParticipantFrameDto() {}

	public MatchParticipantFrameDto(Integer participantId, Integer minionsKilled, Integer teamScore,
			Integer dominionScore, Integer totalGold, Integer level, Integer xp, Integer currentGold,
			MatchPositionDto position, Integer jungleMinionsKilled) {
		ParticipantId = participantId;
		MinionsKilled = minionsKilled;
		TeamScore = teamScore;
		DominionScore = dominionScore;
		TotalGold = totalGold;
		Level = level;
		Xp = xp;
		CurrentGold = currentGold;
		Position = position;
		JungleMinionsKilled = jungleMinionsKilled;
	}

	public Integer getParticipantId() {
		return ParticipantId;
	}

	public void setParticipantId(Integer participantId) {
		ParticipantId = participantId;
	}

	public Integer getMinionsKilled() {
		return MinionsKilled;
	}

	public void setMinionsKilled(Integer minionsKilled) {
		MinionsKilled = minionsKilled;
	}

	public Integer getTeamScore() {
		return TeamScore;
	}

	public void setTeamScore(Integer teamScore) {
		TeamScore = teamScore;
	}

	public Integer getDominionScore() {
		return DominionScore;
	}

	public void setDominionScore(Integer dominionScore) {
		DominionScore = dominionScore;
	}

	public Integer getTotalGold() {
		return TotalGold;
	}

	public void setTotalGold(Integer totalGold) {
		TotalGold = totalGold;
	}

	public Integer getLevel() {
		return Level;
	}

	public void setLevel(Integer level) {
		Level = level;
	}

	public Integer getXp() {
		return Xp;
	}

	public void setXp(Integer xp) {
		Xp = xp;
	}

	public Integer getCurrentGold() {
		return CurrentGold;
	}

	public void setCurrentGold(Integer currentGold) {
		CurrentGold = currentGold;
	}

	public MatchPositionDto getPosition() {
		return Position;
	}

	public void setPosition(MatchPositionDto position) {
		Position = position;
	}

	public Integer getJungleMinionsKilled() {
		return JungleMinionsKilled;
	}

	public void setJungleMinionsKilled(Integer jungleMinionsKilled) {
		JungleMinionsKilled = jungleMinionsKilled;
	}

}
