package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentGameParticipant {
	@JsonProperty("championId")
	private Long ChampionId;
	@JsonProperty("perks")
	private Perks Perks;
	@JsonProperty("profileIconId")
	private Long ProfileIconId;
	@JsonProperty("bot")
	private Boolean Bot;
	@JsonProperty("teamId")
	private Long TeamId;
	@JsonProperty("summonerName")
	private String SummonerName;
	@JsonProperty("summonerId")
	private String SummonerId;
	@JsonProperty("spell1Id")
	private Long Spell1Id;
	@JsonProperty("spell2Id")
	private Long Spell2Id;
	@JsonProperty("gameCustomizationObjects")
	private List<GameCustomizationObject> GameCustomizationObjects;

	public CurrentGameParticipant() {}

	public CurrentGameParticipant(Long championId, com.github.antonioazambuja.noxus.resources.Perks perks, Long profileIconId,
			Boolean bot, Long teamId, String summonerName, String summonerId, Long spell1Id, Long spell2Id,
			List<GameCustomizationObject> gameCustomizationObjects) {
		ChampionId = championId;
		Perks = perks;
		ProfileIconId = profileIconId;
		Bot = bot;
		TeamId = teamId;
		SummonerName = summonerName;
		SummonerId = summonerId;
		Spell1Id = spell1Id;
		Spell2Id = spell2Id;
		GameCustomizationObjects = gameCustomizationObjects;
	}

	public Long getChampionId() {
		return ChampionId;
	}

	public void setChampionId(Long championId) {
		ChampionId = championId;
	}

	public Perks getPerks() {
		return Perks;
	}

	public void setPerks(Perks perks) {
		Perks = perks;
	}

	public Long getProfileIconId() {
		return ProfileIconId;
	}

	public void setProfileIconId(Long profileIconId) {
		ProfileIconId = profileIconId;
	}

	public Boolean getBot() {
		return Bot;
	}

	public void setBot(Boolean bot) {
		Bot = bot;
	}

	public Long getTeamId() {
		return TeamId;
	}

	public void setTeamId(Long teamId) {
		TeamId = teamId;
	}

	public String getSummonerName() {
		return SummonerName;
	}

	public void setSummonerName(String summonerName) {
		SummonerName = summonerName;
	}

	public String getSummonerId() {
		return SummonerId;
	}

	public void setSummonerId(String summonerId) {
		SummonerId = summonerId;
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

	public List<GameCustomizationObject> getGameCustomizationObjects() {
		return GameCustomizationObjects;
	}

	public void setGameCustomizationObjects(List<GameCustomizationObject> gameCustomizationObjects) {
		GameCustomizationObjects = gameCustomizationObjects;
	}
}
