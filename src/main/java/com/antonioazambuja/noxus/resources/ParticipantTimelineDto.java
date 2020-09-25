package com.antonioazambuja.noxus.resources;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class ParticipantTimelineDto {
	@JsonProperty("participantId")
	private Integer ParticipantId;
	@JsonProperty("csDiffPerMinDeltas")
	private Map<String, Double> CsDiffPerMinDeltas;
	@JsonProperty("damageTakenPerMinDeltas")
	private Map<String, Double> DamageTakenPerMinDeltas;
	@JsonProperty("role")
	private String Role;
	@JsonProperty("damageTakenDiffPerMinDeltas")
	private Map<String, Double> DamageTakenDiffPerMinDeltas;
	@JsonProperty("xpPerMinDeltas")
	private Map<String, Double> XpPerMinDeltas;
	@JsonProperty("xpDiffPerMinDeltas")
	private Map<String, Double> XpDiffPerMinDeltas;
	@JsonProperty("lane")
	private String Lane;
	@JsonProperty("creepsPerMinDeltas")
	private Map<String, Double> CreepsPerMinDeltas;
	@JsonProperty("goldPerMinDeltas")
	private Map<String, Double> GoldPerMinDeltas;

	public ParticipantTimelineDto() {}

	public ParticipantTimelineDto(Integer participantId, Map<String, Double> csDiffPerMinDeltas,
			Map<String, Double> damageTakenPerMinDeltas, String role, Map<String, Double> damageTakenDiffPerMinDeltas,
			Map<String, Double> xpPerMinDeltas, Map<String, Double> xpDiffPerMinDeltas, String lane,
			Map<String, Double> creepsPerMinDeltas, Map<String, Double> goldPerMinDeltas) {
		ParticipantId = participantId;
		CsDiffPerMinDeltas = csDiffPerMinDeltas;
		DamageTakenPerMinDeltas = damageTakenPerMinDeltas;
		Role = role;
		DamageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
		XpPerMinDeltas = xpPerMinDeltas;
		XpDiffPerMinDeltas = xpDiffPerMinDeltas;
		Lane = lane;
		CreepsPerMinDeltas = creepsPerMinDeltas;
		GoldPerMinDeltas = goldPerMinDeltas;
	}

	public Integer getParticipantId() {
		return ParticipantId;
	}

	public void setParticipantId(Integer participantId) {
		ParticipantId = participantId;
	}

	public Map<String, Double> getCsDiffPerMinDeltas() {
		return CsDiffPerMinDeltas;
	}

	public void setCsDiffPerMinDeltas(Map<String, Double> csDiffPerMinDeltas) {
		CsDiffPerMinDeltas = csDiffPerMinDeltas;
	}

	public Map<String, Double> getDamageTakenPerMinDeltas() {
		return DamageTakenPerMinDeltas;
	}

	public void setDamageTakenPerMinDeltas(Map<String, Double> damageTakenPerMinDeltas) {
		DamageTakenPerMinDeltas = damageTakenPerMinDeltas;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Map<String, Double> getDamageTakenDiffPerMinDeltas() {
		return DamageTakenDiffPerMinDeltas;
	}

	public void setDamageTakenDiffPerMinDeltas(Map<String, Double> damageTakenDiffPerMinDeltas) {
		DamageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
	}

	public Map<String, Double> getXpPerMinDeltas() {
		return XpPerMinDeltas;
	}

	public void setXpPerMinDeltas(Map<String, Double> xpPerMinDeltas) {
		XpPerMinDeltas = xpPerMinDeltas;
	}

	public Map<String, Double> getXpDiffPerMinDeltas() {
		return XpDiffPerMinDeltas;
	}

	public void setXpDiffPerMinDeltas(Map<String, Double> xpDiffPerMinDeltas) {
		XpDiffPerMinDeltas = xpDiffPerMinDeltas;
	}

	public String getLane() {
		return Lane;
	}

	public void setLane(String lane) {
		Lane = lane;
	}

	public Map<String, Double> getCreepsPerMinDeltas() {
		return CreepsPerMinDeltas;
	}

	public void setCreepsPerMinDeltas(Map<String, Double> creepsPerMinDeltas) {
		CreepsPerMinDeltas = creepsPerMinDeltas;
	}

	public Map<String, Double> getGoldPerMinDeltas() {
		return GoldPerMinDeltas;
	}

	public void setGoldPerMinDeltas(Map<String, Double> goldPerMinDeltas) {
		GoldPerMinDeltas = goldPerMinDeltas;
	}

}
