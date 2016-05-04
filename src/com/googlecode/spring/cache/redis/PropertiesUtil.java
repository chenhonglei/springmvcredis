package com.googlecode.spring.cache.redis;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties readConfi(String path) {
		Properties pro = new Properties();
		try {
			pro.load(PropertiesUtil.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
}
