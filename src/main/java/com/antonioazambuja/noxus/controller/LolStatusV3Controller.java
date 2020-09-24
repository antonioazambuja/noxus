package com.antonioazambuja.noxus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.ShardStatus;
import com.antonioazambuja.noxus.service.LolStatusV3;

@RestController
public class LolStatusV3Controller {

	@Autowired
	private LolStatusV3 lolStatusV3;

	@RequestMapping("/shard/status")
	public ShardStatus getChampionRotation() {
		return lolStatusV3.getStatusShardData();
	}

}
