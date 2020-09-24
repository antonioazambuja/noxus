package com.antonioazambuja.noxus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.CurrentGameInfo;
import com.antonioazambuja.noxus.resources.FeaturedGame;
import com.antonioazambuja.noxus.service.SpectatorV4;

@RestController
public class SpectatorV4Controller {

	@Autowired
	private SpectatorV4 spectatorV4;

	@RequestMapping("/featured-games")
	public FeaturedGame getFeaturedGames() {
		return spectatorV4.getFeatuedGames();
	}

	@RequestMapping("/active-games/by-summoner/{encryptedSummonerId}")
	public CurrentGameInfo getFeaturedGames(@PathVariable(value="encryptedSummonerId") String encryptedSummonerId) {
		return spectatorV4.getActiveGamesBySummoner(encryptedSummonerId);
	}
}
