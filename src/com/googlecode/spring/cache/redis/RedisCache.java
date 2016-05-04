package com.googlecode.spring.cache.redis;

import java.io.Serializable;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;

import redis.clients.jedis.Jedis;
public class RedisCache implements Cache{
	private Jedis cache;
	private final String name;
	
	public RedisCache(String name){
		this(null,name);
	}
	
	public RedisCache(Jedis cache,String name){
		this.cache = cache;
		this.name = name;
	}
	
	public void setCache(Jedis cache){
		this.cache = cache;
	}
	
	@Override
	public void clear() {
		cache.flushDB();
	}

	@Override
	public void evict(Object cacheValue) {
		Item key = new Item(cacheValue);
		byte[] k = serializeObject(key);
		cache.del(k);
	}

	@Override
	public ValueWrapper get(Object cacheValue) {
		if ( cacheValue == null ) {
			return null;
		}
		Item key = new Item(cacheValue);
		byte[] k = serializeObject(key);
		byte[] result = cache.get( k );
		if ( result != null ) {
			Item vi = (Item)deserializeObject(result);
			ValueWrapper v = new SimpleValueWrapper(vi.getValue());
			
			return v;
		}
		
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getNativeCache() {
		return cache;
	}

	@Override
	public void put(Object cacheKey, Object cacheValue) {
		cache.set(cacheKey.toString(),cacheValue.toString());
	}
	
	protected byte[] serializeObject(Object obj){
		SerializingConverter sc = new SerializingConverter();
		return sc.convert(obj);
 	}
	
	protected Object deserializeObject(byte[] b){
 		DeserializingConverter dc = new DeserializingConverter();
		return dc.convert(b);
	}
	
	protected final static class Item implements Serializable{
		private static final long serialVersionUID = 1L;
		private final Object value;
		
		Item(Object value) {
			this.value = value;
		}
		
		public Object getValue() {
			return value;
		}
	}

	@Override
	public <T> T get(Object arg0, Class<T> arg1) {
		return null;
	}
}
