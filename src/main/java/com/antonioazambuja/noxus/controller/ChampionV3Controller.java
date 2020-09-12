package com.antonioazambuja.noxus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.ChampionInfoV3;
import com.antonioazambuja.noxus.service.ChampionV3;

@RestController
public class ChampionV3Controller {

	@Autowired
	private ChampionV3 championV3;

	@RequestMapping("/champion/rotation")
	public ChampionInfoV3 getChampionRotation() {
		return championV3.getChampionRotation();
	}

}
