package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class LeagueListDTO {
	@JsonProperty("leagueId")
	private String LeagueID;
	@JsonProperty("entries")
	private List<LeagueItemDTO> Entries;
	@JsonProperty("tier")
	private String Tier;
	@JsonProperty("name")
	private String Name;
	@JsonProperty("queue")
	private String Queue;

	public LeagueListDTO(String leagueID, List<LeagueItemDTO> entries, String tier, String name, String queue) {
		LeagueID = leagueID;
		Entries = entries;
		Tier = tier;
		Name = name;
		Queue = queue;
	}

	public LeagueListDTO() {}

	public String getLeagueID() {
		return LeagueID;
	}

	public void setLeagueID(String leagueID) {
		LeagueID = leagueID;
	}

	public List<LeagueItemDTO> getEntries() {
		return Entries;
	}

	public void setEntries(List<LeagueItemDTO> entries) {
		Entries = entries;
	}

	public String getTier() {
		return Tier;
	}

	public void setTier(String tier) {
		Tier = tier;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getQueue() {
		return Queue;
	}

	public void setQueue(String queue) {
		Queue = queue;
	}
}
