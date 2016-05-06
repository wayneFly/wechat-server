package com.wechat.util;

import java.util.ResourceBundle;

public class ConfigUtil {

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("config");

	public static String getValue(String key) {
		return BUNDLE.getString(key);
	}
}
