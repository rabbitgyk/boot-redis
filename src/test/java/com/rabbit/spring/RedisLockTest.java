package com.rabbit.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisLockTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void testStringSet() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "guoyankui");
		Assert.assertEquals("guoyankui", stringRedisTemplate.opsForValue().get("aaa"));
	}
	
	@Test
	public void testLockSet() throws Exception {
		Boolean b = stringRedisTemplate.opsForValue().setIfAbsent("bbb", "guoyankui");
		
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testLockRelease() throws Exception {
		stringRedisTemplate.delete("bbb");
	}
	
	
}
