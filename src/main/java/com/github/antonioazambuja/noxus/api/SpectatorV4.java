package com.github.antonioazambuja.noxus.api;

import com.github.antonioazambuja.noxus.resources.CurrentGameInfo;
import com.github.antonioazambuja.noxus.resources.FeaturedGame;

public interface SpectatorV4 {
	FeaturedGame getFeaturedGames();
	CurrentGameInfo getActiveGamesBySummoner(String encryptedSummonerId);
}
