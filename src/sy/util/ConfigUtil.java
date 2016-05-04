package sy.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 项目参数工具类
 */
public class ConfigUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("redis",Locale.CHINESE);
	/**
	 * 通过键获取值
	 * 
	 * @param key
	 * @return
	 */
	public static final String get(String key) {
		return bundle.getString(key);
	}
	
	
	public static void main(String[] args) {
		System.out.println(get("redis.port"));
	}
}
