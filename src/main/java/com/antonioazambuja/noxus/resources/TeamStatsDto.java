package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class TeamStatsDto {
	@JsonProperty("towerKills")
	private Integer TowerKills;
	@JsonProperty("riftHeraldKills")
	private Integer RiftHeraldKills;
	@JsonProperty("firstBlood")
	private Boolean FirstBlood;
	@JsonProperty("inhibitorKills")
	private Integer InhibitorKills;
	@JsonProperty("bans")
	private List<TeamBansDto> Bans;
	@JsonProperty("firstBaron")
	private Boolean FirstBaron;
	@JsonProperty("firstDragon")
	private Boolean FirstDragon;
	@JsonProperty("dominionVictoryScore")
	private Integer DominionVictoryScore;
	@JsonProperty("dragonKills")
	private Integer DragonKills;
	@JsonProperty("baronKills")
	private Integer BaronKills;
	@JsonProperty("firstInhibitor")
	private Boolean FirstInhibitor;
	@JsonProperty("firstTower")
	private Boolean FirstTower;
	@JsonProperty("vilemawKills")
	private Integer VilemawKills;
	@JsonProperty("firstRiftHerald")
	private Boolean FirstRiftHerald;
	@JsonProperty("teamId")
	private Integer TeamId;
	@JsonProperty("win")
	private String Win;

	public TeamStatsDto() {}

	public TeamStatsDto(Integer towerKills, Integer riftHeraldKills, Boolean firstBlood, Integer inhibitorKills,
			List<TeamBansDto> bans, Boolean firstBaron, Boolean firstDragon, Integer dominionVictoryScore,
			Integer dragonKills, Integer baronKills, Boolean firstInhibitor, Boolean firstTower, Integer vilemawKills,
			Boolean firstRiftHerald, Integer teamId, String win) {
		TowerKills = towerKills;
		RiftHeraldKills = riftHeraldKills;
		FirstBlood = firstBlood;
		InhibitorKills = inhibitorKills;
		Bans = bans;
		FirstBaron = firstBaron;
		FirstDragon = firstDragon;
		DominionVictoryScore = dominionVictoryScore;
		DragonKills = dragonKills;
		BaronKills = baronKills;
		FirstInhibitor = firstInhibitor;
		FirstTower = firstTower;
		VilemawKills = vilemawKills;
		FirstRiftHerald = firstRiftHerald;
		TeamId = teamId;
		Win = win;
	}

	public Integer getTowerKills() {
		return TowerKills;
	}

	public void setTowerKills(Integer towerKills) {
		TowerKills = towerKills;
	}

	public Integer getRiftHeraldKills() {
		return RiftHeraldKills;
	}

	public void setRiftHeraldKills(Integer riftHeraldKills) {
		RiftHeraldKills = riftHeraldKills;
	}

	public Boolean getFirstBlood() {
		return FirstBlood;
	}

	public void setFirstBlood(Boolean firstBlood) {
		FirstBlood = firstBlood;
	}

	public Integer getInhibitorKills() {
		return InhibitorKills;
	}

	public void setInhibitorKills(Integer inhibitorKills) {
		InhibitorKills = inhibitorKills;
	}

	public List<TeamBansDto> getBans() {
		return Bans;
	}

	public void setBans(List<TeamBansDto> bans) {
		Bans = bans;
	}

	public Boolean getFirstBaron() {
		return FirstBaron;
	}

	public void setFirstBaron(Boolean firstBaron) {
		FirstBaron = firstBaron;
	}

	public Boolean getFirstDragon() {
		return FirstDragon;
	}

	public void setFirstDragon(Boolean firstDragon) {
		FirstDragon = firstDragon;
	}

	public Integer getDominionVictoryScore() {
		return DominionVictoryScore;
	}

	public void setDominionVictoryScore(Integer dominionVictoryScore) {
		DominionVictoryScore = dominionVictoryScore;
	}

	public Integer getDragonKills() {
		return DragonKills;
	}

	public void setDragonKills(Integer dragonKills) {
		DragonKills = dragonKills;
	}

	public Integer getBaronKills() {
		return BaronKills;
	}

	public void setBaronKills(Integer baronKills) {
		BaronKills = baronKills;
	}

	public Boolean getFirstInhibitor() {
		return FirstInhibitor;
	}

	public void setFirstInhibitor(Boolean firstInhibitor) {
		FirstInhibitor = firstInhibitor;
	}

	public Boolean getFirstTower() {
		return FirstTower;
	}

	public void setFirstTower(Boolean firstTower) {
		FirstTower = firstTower;
	}

	public Integer getVilemawKills() {
		return VilemawKills;
	}

	public void setVilemawKills(Integer vilemawKills) {
		VilemawKills = vilemawKills;
	}

	public Boolean getFirstRiftHerald() {
		return FirstRiftHerald;
	}

	public void setFirstRiftHerald(Boolean firstRiftHerald) {
		FirstRiftHerald = firstRiftHerald;
	}

	public Integer getTeamId() {
		return TeamId;
	}

	public void setTeamId(Integer teamId) {
		TeamId = teamId;
	}

	public String getWin() {
		return Win;
	}

	public void setWin(String win) {
		Win = win;
	}

}
