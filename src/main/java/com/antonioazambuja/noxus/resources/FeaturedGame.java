package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class FeaturedGame {
	@JsonProperty("gameList")
	private List<FeaturedGameInfo> GameList;
	@JsonProperty("clientRefreshInterval")
	private Long ClientRefreshInterval;

	public FeaturedGame() {}

	public FeaturedGame(List<FeaturedGameInfo> gameList, Long clientRefreshInterval) {
		GameList = gameList;
		ClientRefreshInterval = clientRefreshInterval;
	}

	public List<FeaturedGameInfo> getGameList() {
		return GameList;
	}

	public void setGameList(List<FeaturedGameInfo> gameList) {
		GameList = gameList;
	}

	public Long getClientRefreshInterval() {
		return ClientRefreshInterval;
	}

	public void setClientRefreshInterval(Long clientRefreshInterval) {
		ClientRefreshInterval = clientRefreshInterval;
	}
}
