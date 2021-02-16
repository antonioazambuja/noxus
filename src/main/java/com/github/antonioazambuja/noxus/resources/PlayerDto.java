package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDto {
	@JsonProperty("profileIcon")
	private Integer ProfileIcon;
	@JsonProperty("accountId")
	private String AccountId;
	@JsonProperty("matchHistoryUri")
	private String MatchHistoryUri;
	@JsonProperty("currentAccountId")
	private String CurrentAccountId;
	@JsonProperty("currentPlatformId")
	private String CurrentPlatformId;
	@JsonProperty("summonerName")
	private String SummonerName;
	@JsonProperty("summonerId")
	private String SummonerId;
	@JsonProperty("platformId")
	private String PlatformId;

	public PlayerDto() {}

	public PlayerDto(Integer profileIcon, String accountId, String matchHistoryUri, String currentAccountId,
			String currentPlatformId, String summonerName, String summonerId, String platformId) {
		ProfileIcon = profileIcon;
		AccountId = accountId;
		MatchHistoryUri = matchHistoryUri;
		CurrentAccountId = currentAccountId;
		CurrentPlatformId = currentPlatformId;
		SummonerName = summonerName;
		SummonerId = summonerId;
		PlatformId = platformId;
	}

	public Integer getProfileIcon() {
		return ProfileIcon;
	}

	public void setProfileIcon(Integer profileIcon) {
		ProfileIcon = profileIcon;
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}

	public String getMatchHistoryUri() {
		return MatchHistoryUri;
	}

	public void setMatchHistoryUri(String matchHistoryUri) {
		MatchHistoryUri = matchHistoryUri;
	}

	public String getCurrentAccountId() {
		return CurrentAccountId;
	}

	public void setCurrentAccountId(String currentAccountId) {
		CurrentAccountId = currentAccountId;
	}

	public String getCurrentPlatformId() {
		return CurrentPlatformId;
	}

	public void setCurrentPlatformId(String currentPlatformId) {
		CurrentPlatformId = currentPlatformId;
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

	public String getPlatformId() {
		return PlatformId;
	}

	public void setPlatformId(String platformId) {
		PlatformId = platformId;
	}

}
