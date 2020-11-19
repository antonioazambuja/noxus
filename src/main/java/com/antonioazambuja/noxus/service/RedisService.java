package com.antonioazambuja.noxus.service;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.antonioazambuja.noxus.exceptions.NotFoundCacheException;
import com.google.gson.Gson;
import com.google.gson.internal.Primitives;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

	@Autowired
	private Gson gson;

	@Autowired
	private JedisPool redisPool;

	private Integer CACHE_TTL_DAYS = 1;

	public Long expireAt(String cacheKey) {
		Jedis redisClient = redisPool.getResource();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, CACHE_TTL_DAYS);
		Long expireAt = redisClient.expireAt(cacheKey, calendar.getTimeInMillis());
		redisClient.close();
		return expireAt;
	}

	public String setCache(String cacheKey, ResponseEntity<?> response) {
		Jedis redisClient = redisPool.getResource();
		String cacheResponse = redisClient.set(cacheKey, gson.toJson(response.getBody()));
		this.expireAt(cacheKey);
		return cacheResponse;
	}

	public <T> T getCache(String cacheKey, Class<T> classOfT) {
		Jedis redisClient = redisPool.getResource();
		T cacheResult = Primitives.wrap(classOfT).cast(gson.fromJson(redisClient.get(cacheKey), (Type) classOfT));
		if (cacheResult == null) {
			throw new NotFoundCacheException("Not found cache requested...");
		}
		return cacheResult;
	}

}
