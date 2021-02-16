package com.github.antonioazambuja.noxus;

public enum Regions {
	BR1("br1.api.riotgames.com"),
	EUN1("eun1.api.riotgames.com"),
	EUW1("euw1.api.riotgames.com"),
	JP1("jp1.api.riotgames.com"),
	KR("kr.api.riotgames.com"),
	LA1("la1.api.riotgames.com"),
	LA2("la2.api.riotgames.com"),
	NA1("na1.api.riotgames.com"),
	OC1("oc1.api.riotgames.com"),
	TR1("tr1.api.riotgames.com"),
	RU("ru.api.riotgames.com");

	private String apiRegionEndpoint;

	public String getApiRegionEndpoint() {
		return this.apiRegionEndpoint;
	}

	private Regions(String apiRegionEndpoint) {
		this.apiRegionEndpoint = apiRegionEndpoint;
	}
}
