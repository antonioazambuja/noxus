package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO {
	@JsonProperty("puuid")
	private String Puuid;
	@JsonProperty("gameName")
	private String GameName;
	@JsonProperty("tagLine")
	private String TagLine;

	public String getPuuid() {
		return Puuid;
	}
	public void setPuuid(String puuid) {
		Puuid = puuid;
	}
	public String getGameName() {
		return GameName;
	}
	public void setGameName(String gameName) {
		GameName = gameName;
	}
	public String getTagLine() {
		return TagLine;
	}
	public void setTagLine(String tagLine) {
		TagLine = tagLine;
	}
}
