package com.rabbit.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbit.spring.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootRedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void testStringSet() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}
	
	@Test
	public void testUserSet() throws Exception {
		User user1 = new User("超人", "Superman");
		User user2 = new User("蝙蝠侠", "Batman");
		User user3 = new User("蜘蛛侠", "Spiderman");
		redisTemplate.opsForValue().set(user1.getName(), user1);
		redisTemplate.opsForValue().set(user2.getName(), user2);
		redisTemplate.opsForValue().set(user3.getName(), user3);
		
		System.out.println(redisTemplate.opsForValue().get("超人").getName());
		
		Assert.assertEquals("Superman", redisTemplate.opsForValue().get("超人").getPw());
		Assert.assertEquals("Batman", redisTemplate.opsForValue().get("蝙蝠侠").getPw());
		Assert.assertEquals("Spiderman", redisTemplate.opsForValue().get("蜘蛛侠").getPw());
	}

}
