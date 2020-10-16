package com.antonioazambuja.noxus.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class UtilsService {

	@Autowired
	private Jedis redisClient;

	private Integer CACHE_TTL = 1;

	public Long expireAt(String cacheKey) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, CACHE_TTL);
		return redisClient.expireAt(cacheKey, calendar.getTimeInMillis());
	}

}
