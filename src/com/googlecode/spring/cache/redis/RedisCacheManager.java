package com.googlecode.spring.cache.redis;

import java.util.Collection;
import java.util.Properties;

import org.apache.commons.pool.impl.GenericObjectPool.Config;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisCacheManager extends AbstractCacheManager{
	private Collection<? extends Cache> caches;
	
	public void setCaches(Collection<? extends Cache> caches) {
		this.caches = caches;
	}
	
	@Override
	protected Collection<? extends Cache> loadCaches() {
		int i = 0;
		
		Properties pro = PropertiesUtil.readConfi("/redis.config.properties");
		
		Config config = new Config();
		// 控制一个pool最多有多少个状态为idle的jedis实例
		config.maxActive = Integer.valueOf(pro.getProperty("maxActive", "100"));
		// 最大能够保持空闲状态的对象数
		config.maxIdle = Integer.valueOf(pro.getProperty("maxIdle", "300"));
		// 超时时间
		config.maxWait = Integer.valueOf(pro.getProperty("maxWait", "1000"));

		// 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
		config.testOnBorrow = Boolean.valueOf(pro.getProperty("testOnBorrow",
				"false"));
		// 在还会给pool时，是否提前进行validate操作
		config.testOnReturn = Boolean.valueOf(pro.getProperty("testOnReturn",
				"false"));
		
		//服务器地址
		String host = pro.getProperty("host", "127.0.0.1");
		//端口
		int port = Integer.valueOf(pro.getProperty("port", "6379"));
		int timeout = Integer.valueOf(pro.getProperty("timeout", "1000"));
		//密码
		String proPassword = pro.getProperty("proPassword", "123456");
		
		JedisPool pool = new JedisPool(config, host, port, timeout,proPassword);
		for (Cache cache : caches){
			Jedis jedis = pool.getResource();
			jedis.select(i++);
			
			RedisCache rc = (RedisCache)cache;
			rc.setCache(jedis);
		}
		
		return this.caches;
	}
}
