package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class ParticipantDto {
	@JsonProperty("participantId")
	private Integer ParticipantId;
	@JsonProperty("championId")
	private Integer ChampionId;
	@JsonProperty("runes")
	private List<RuneDto> Runes;
	@JsonProperty("stats")
	private ParticipantStatsDto Stats;
	@JsonProperty("teamId")
	private Integer TeamId;
	@JsonProperty("timeline")
	private ParticipantTimelineDto Timeline;
	@JsonProperty("spell1Id")
	private Integer Spell1Id;
	@JsonProperty("spell2Id")
	private Integer Spell2Id;
	@JsonProperty("highestAchievedSeasonTier")
	private String HighestAchievedSeasonTier;
	@JsonProperty("masteries")
	private List<MasteryDto> Masteries;

	public ParticipantDto() {}

	public ParticipantDto(Integer participantId, Integer championId, List<RuneDto> runes, ParticipantStatsDto stats, Integer teamId,
			ParticipantTimelineDto timeline, Integer spell1Id, Integer spell2Id, String highestAchievedSeasonTier,
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

	public Integer getChampionId() {
		return ChampionId;
	}

	public void setChampionId(Integer championId) {
		ChampionId = championId;
	}

	public List<RuneDto> getRunes() {
		return Runes;
	}

	public void setRunes(List<RuneDto> runes) {
		Runes = runes;
	}

	public ParticipantStatsDto getStats() {
		return Stats;
	}

	public void setStats(ParticipantStatsDto stats) {
		Stats = stats;
	}

	public Integer getTeamId() {
		return TeamId;
	}

	public void setTeamId(Integer teamId) {
		TeamId = teamId;
	}

	public ParticipantTimelineDto getTimeline() {
		return Timeline;
	}

	public void setTimeline(ParticipantTimelineDto timeline) {
		Timeline = timeline;
	}

	public Integer getSpell1Id() {
		return Spell1Id;
	}

	public void setSpell1Id(Integer spell1Id) {
		Spell1Id = spell1Id;
	}

	public Integer getSpell2Id() {
		return Spell2Id;
	}

	public void setSpell2Id(Integer spell2Id) {
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
