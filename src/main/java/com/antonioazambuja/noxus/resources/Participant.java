package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class Participant {
	@JsonProperty("participantId")
	private Integer ParticipantId;
	@JsonProperty("championId")
	private Long ChampionId;
	@JsonProperty("runes")
	private List<RuneDto> Runes;
	@JsonProperty("stats")
	private ParticipantDto Stats;
	@JsonProperty("teamId")
	private Long TeamId;
	@JsonProperty("timeline")
	private ParticipantTimelineDto Timeline;
	@JsonProperty("spell1Id")
	private Long Spell1Id;
	@JsonProperty("spell2Id")
	private Long Spell2Id;
	@JsonProperty("highestAchievedSeasonTier")
	private String HighestAchievedSeasonTier;
	@JsonProperty("masteries")
	private List<MasteryDto> Masteries;

	public Participant() {}

	public Participant(Integer participantId, Long championId, List<RuneDto> runes, ParticipantDto stats, Long teamId,
			ParticipantTimelineDto timeline, Long spell1Id, Long spell2Id, String highestAchievedSeasonTier,
			List<MasteryDto> masteries) {
		ParticipantId = participantId;
		ChampionId = championId;
		Runes = runes;
		Stats = stats;
		TeamId = teamId;
		Timeline = timeline;
		Spell1Id = spell1Id;
		Spell2Id = spell2Id;
		HighestAchievedSeasonTier = highestAchievedSeasonTier;
		Masteries = masteries;
	}

	public Integer getParticipantId() {
		return ParticipantId;
	}

	public void setParticipantId(Integer participantId) {
		ParticipantId = participantId;
	}

	public Long getChampionId() {
		return ChampionId;
	}

	public void setChampionId(Long championId) {
		ChampionId = championId;
	}

	public List<RuneDto> getRunes() {
		return Runes;
	}

	public void setRunes(List<RuneDto> runes) {
		Runes = runes;
	}

	public ParticipantDto getStats() {
		return Stats;
	}

	public void setStats(ParticipantDto stats) {
		Stats = stats;
	}

	public Long getTeamId() {
		return TeamId;
	}

	public void setTeamId(Long teamId) {
		TeamId = teamId;
	}

	public ParticipantTimelineDto getTimeline() {
		return Timeline;
	}

	public void setTimeline(ParticipantTimelineDto timeline) {
		Timeline = timeline;
	}

	public Long getSpell1Id() {
		return Spell1Id;
	}

	public void setSpell1Id(Long spell1Id) {
		Spell1Id = spell1Id;
	}

	public Long getSpell2Id() {
		return Spell2Id;
	}

	public void setSpell2Id(Long spell2Id) {
		Spell2Id = spell2Id;
	}

	public String getHighestAchievedSeasonTier() {
		return HighestAchievedSeasonTier;
	}

	public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
		HighestAchievedSeasonTier = highestAchievedSeasonTier;
	}

	public List<MasteryDto> getMasteries() {
		return Masteries;
	}

	public void setMasteries(List<MasteryDto> masteries) {
		Masteries = masteries;
	}

}
