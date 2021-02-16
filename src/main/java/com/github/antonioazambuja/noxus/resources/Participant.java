package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Participant {
	@JsonProperty("bot")
	private Boolean Bot;
	@JsonProperty("spell2Id")
	private Long Spell2Id;
	@JsonProperty("profileIconId")
	private Long ProfileIconId;
	@JsonProperty("summonerName")
	private String SummonerName;
	@JsonProperty("championId")
	private Long ChampionId;
	@JsonProperty("teamId")
	private Long TeamId;
	@JsonProperty("spell1Id")
	private Long Spell1Id;

	public Participant(Boolean bot, Long spell2Id, Long profileIconId, String summonerName, Long championId,
			Long teamId, Long spell1Id) {
		Bot = bot;
		Spell2Id = spell2Id;
		ProfileIconId = profileIconId;
		SummonerName = summonerName;
		ChampionId = championId;
		TeamId = teamId;
		Spell1Id = spell1Id;
	}

	public Participant() {}

	public Boolean getBot() {
		return Bot;
	}
	public void setBot(Boolean bot) {
		Bot = bot;
	}
	public Long getSpell2Id() {
		return Spell2Id;
	}
	public void setSpell2Id(Long spell2Id) {
		Spell2Id = spell2Id;
	}
	public Long getProfileIconId() {
		return ProfileIconId;
	}
	public void setProfileIconId(Long profileIconId) {
		ProfileIconId = profileIconId;
	}
	public String getSummonerName() {
		return SummonerName;
	}
	public void setSummonerName(String summonerName) {
		SummonerName = summonerName;
	}
	public Long getChampionId() {
		return ChampionId;
	}
	public void setChampionId(Long championId) {
		ChampionId = championId;
	}
	public Long getTeamId() {
		return TeamId;
	}
	public void setTeamId(Long teamId) {
		TeamId = teamId;
	}
	public Long getSpell1Id() {
		return Spell1Id;
	}
	public void setSpell1Id(Long spell1Id) {
		Spell1Id = spell1Id;
	}

}
