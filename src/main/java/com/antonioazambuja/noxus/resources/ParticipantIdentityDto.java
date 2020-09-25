package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class ParticipantIdentityDto {
	@JsonProperty("participantId")
	private Integer ParticipantId;
	@JsonProperty("player")
	private PlayerDto Player;

	public ParticipantIdentityDto() {}

	public ParticipantIdentityDto(Integer participantId, PlayerDto player) {
		ParticipantId = participantId;
		Player = player;
	}

	public Integer getParticipantId() {
		return ParticipantId;
	}

	public void setParticipantId(Integer participantId) {
		ParticipantId = participantId;
	}

	public PlayerDto getPlayer() {
		return Player;
	}

	public void setPlayer(PlayerDto player) {
		Player = player;
	}

}
