package com.googlecode.spring.cache.redis.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.bai.util.redis.RedisUtil;

@Service
public class RedisCacheService {
	@Resource
	private RedisUtil redis;
//	@Resource
//	private RedisTemplate<Serializable, Object> redisTemplate;
	private Long defaultCacheExpireTime = 3600l; // 缓存默认的过期时间,这里设置了10秒
	
	@Cacheable(value="default" , key="#userId")
	public List<String> printUserId(String userId){
		List<String> lists = new ArrayList<String>();
		lists.add("132234234234111111111111111115");
		lists.add("22");
		lists.add("33");
		
		return lists;
		
	}
	
	
	
	@Cacheable(value="testCache" , key="#userId")
	public String getCacheNameTestCache(String userId){
		String str="chenhonglei_000000000002222220000001";
		
		return str;
		
	}
	
	
	// 清空default 缓存  
	@CacheEvict(value="default",allEntries=true)
	public void reload() {  
	}  
	
	// 清空default 缓存  
	@CacheEvict(value="testCache",allEntries=true)
	public void reloadTestCache() {  
	}  
	
	@CacheEvict(value="default",key="#userId")
	public void flushUserId(String userId){
		System.out.println("flush cache |" +userId +"| RedisCacheService.printUserId");
	}
	
	@SuppressWarnings("unchecked")
//	public Map<String, String> getCacheMap(String strkey) {
//		Object value = null;
//		Map<String, String> maps = new HashMap<String,String>();
//		maps.put("test_01", "chenhonglei_00001");
//		maps.put("test_02", "chenhonglei_00002");
//		maps.put("test_03", "chenhonglei_00003");
//		maps.put("test_04", "chenhonglei_00004");
//		maps.put("test_05", "chenhonglei_00005");
//		if (exists(strkey)) {
//			value=getCache(strkey);
//		}else {
//			setCache(strkey, maps, defaultCacheExpireTime);
//			value = getCache(strkey);
//		}
//		
//		 return (Map<String, String>) value;
//	}

	public Map<String, String> getCacheMap1(String strkey) {
		Object value = null;
		Map<String, String> maps = new HashMap<String,String>();
		maps.put("test_01", "chenhonglei_000444442222333333201");
		maps.put("test_02", "chenhonglei_00002");
		maps.put("test_03", "chenhonglei_00003");
		maps.put("test_04", "chenhonglei_00004");
		maps.put("test_05", "chenhonglei_00005");
		if (redis.exists(strkey)) {
			value=redis.get(strkey);
		}else {
			redis.set(strkey, maps, defaultCacheExpireTime);
			value = redis.get(strkey);
		}
		
		 return (Map<String, String>) value;
	}


//	public RedisTemplate<Serializable, Object> getRedisTemplate() {
//		return redisTemplate;
//	}
//
//
//
//	public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
//		this.redisTemplate = redisTemplate;
//	}
	
	
	
	//////////////////////////////////////////////////////////////
	/**
	 * 创建缓存key
	 *
	 * @param targetName
	 * @param methodName
	 * @param arguments
	 */
	private String getCacheKey(String targetName, String methodName,
			Object[] arguments) {
		StringBuffer sbu = new StringBuffer();
		sbu.append(targetName).append("_").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				sbu.append("_").append(arguments[i]);
			}
		}
		return sbu.toString();
	}


	
	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 */
//	public boolean exists(final String key) {
//		return redisTemplate.hasKey(key);
//	}

	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
//	public Object getCache(final String key) {
//		Object result = null;
//		ValueOperations<Serializable, Object> operations = redisTemplate
//				.opsForValue();
//		result = operations.get(key);
//		return result;
//	}



	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
//	public boolean setCache(final String key, Object value, Long expireTime) {
//		boolean result = false;
//		try {
//			ValueOperations<Serializable, Object> operations = redisTemplate
//					.opsForValue();
//			operations.set(key, value);
//			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//			result = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
}
