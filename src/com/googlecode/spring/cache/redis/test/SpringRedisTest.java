package com.googlecode.spring.cache.redis.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRedisTest {
	 private static ApplicationContext context;

	public static void main(String[] args) {
		 context = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
		 RedisCacheService service = (RedisCacheService)context.getBean("redisCacheService");
		 
		Map<String,String> maps = service.getCacheMap1("ttmap_0021");
		System.out.println( maps.get("test_01"));
		 
//		 System.out.println(lists.get(0));
//		 System.out.println(str);
		 //清空缓存
//		 service.reload();
//		 service.reloadTestCache();
	}

}
