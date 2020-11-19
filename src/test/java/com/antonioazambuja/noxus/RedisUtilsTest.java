package com.antonioazambuja.noxus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.service.RedisService;

@RunWith(MockitoJUnitRunner.class)
public class RedisUtilsTest {

	@Mock
    private RedisService redisUtilsService;

	@Test
	public void expireAtTest() {
		String cacheKey = "cacheKey";
		Long expireAt = new Long(0);
		Mockito
			.when(redisUtilsService.expireAt(cacheKey))
			.thenReturn(expireAt);
		Assert.assertEquals(redisUtilsService.expireAt(cacheKey), expireAt);
		Mockito.verify(redisUtilsService).expireAt(cacheKey);
	}
}
