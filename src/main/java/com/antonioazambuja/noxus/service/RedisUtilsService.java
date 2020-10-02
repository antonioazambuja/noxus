package com.antonioazambuja.noxus.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class RedisUtilsService {

	@Autowired
	private Jedis redisClient;

	public Long expireAt(String cacheKey) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		return redisClient.expireAt(cacheKey, calendar.getTimeInMillis());
	}

}
