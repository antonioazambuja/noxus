package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ShardStatus;

@Service
public class LolStatusV3 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;
	
	public ShardStatus getStatusShardData() {
		ResponseEntity<ShardStatus> shardStatus = restTemplate.exchange(
				"https://br1.api.riotgames.com" + "/lol/status/v3/shard-data",
				HttpMethod.GET,
				request,
				ShardStatus.class
		);
		return shardStatus.getBody();
	}
}
