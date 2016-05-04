package com.googlecode.spring.cache.redis;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

public class RedisCacheFactoryBean implements FactoryBean<RedisCache>, BeanNameAware, InitializingBean{
	private String name = "";
	private RedisCache cache;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public RedisCache getObject() throws Exception {
		return this.cache;
	}

	@Override
	public Class<?> getObjectType() {
		return cache.getClass();
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public void setBeanName(String arg0) {
		if (!StringUtils.hasLength(this.name)) {
			setName(arg0);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (cache == null){
			cache = new RedisCache(name);
		}
	}
}
