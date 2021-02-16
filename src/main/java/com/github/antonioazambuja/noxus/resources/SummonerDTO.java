package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SummonerDTO {
	@JsonProperty("accountId")
	private String AccountId;
	@JsonProperty("profileIconId")
	private Integer ProfileIconId;
	@JsonProperty("revisionDate")
	private Long RevisionDate;
	@JsonProperty("name")
	private String Name;
	@JsonProperty("id")
	private String Id;
	@JsonProperty("puuid")
	private String Puuid;
	@JsonProperty("summonerLevel")
	private Long SummonerLevel;

	public SummonerDTO() {}

	public SummonerDTO(String accountId, Integer profileIconId, Long revisionDate, String name, String id, String puuid,
			Long summonerLevel) {
		AccountId = accountId;
		ProfileIconId = profileIconId;
		RevisionDate = revisionDate;
		Name = name;
		Id = id;
		Puuid = puuid;
		SummonerLevel = summonerLevel;
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}

	public Integer getProfileIconId() {
		return ProfileIconId;
	}

	public void setProfileIconId(Integer profileIconId) {
		ProfileIconId = profileIconId;
	}

	public Long getRevisionDate() {
		return RevisionDate;
	}

	public void setRevisionDate(Long revisionDate) {
		RevisionDate = revisionDate;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPuuid() {
		return Puuid;
	}

	public void setPuuid(String puuid) {
		Puuid = puuid;
	}

	public Long getSummonerLevel() {
		return SummonerLevel;
	}

	public void setSummonerLevel(Long summonerLevel) {
		SummonerLevel = summonerLevel;
	}

}
