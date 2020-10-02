package com.antonioazambuja.noxus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antonioazambuja.noxus.resources.ShardStatus;

@Service
public class LolStatusV3Service {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity<Object> request;

	@Value("${RIOT_API}")
	private String riotApi;

	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public ShardStatus getStatusShardData() {
		ResponseEntity<ShardStatus> shardStatus = restTemplate.exchange(
				riotApi + "/lol/status/v3/shard-data",
				HttpMethod.GET,
				request,
				ShardStatus.class
		);
		return shardStatus.getBody();
	}
}
