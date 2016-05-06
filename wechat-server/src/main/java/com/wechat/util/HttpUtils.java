package com.wechat.util;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class HttpUtils {

	public static String getRequest(String url, Map<String, Object> params) {
		RestTemplate restTemplate = RestTemplateUtils.getClient();
		String response = restTemplate.getForObject(url, String.class, params);
		return response;
	}

	public static String getRequest(String url, String params) {
		RestTemplate restTemplate = RestTemplateUtils.getClient();
		String response = restTemplate.getForObject(url, String.class, params);
		return response;
	}

	public static String postRequest(String url, Map<String, Object> params) {
		RestTemplate restTemplate = RestTemplateUtils.getClient();
		String response = restTemplate.postForObject(url, null, String.class, params);
		return response;
	}

	public static String postRequest(String url, String params) {
		RestTemplate restTemplate = RestTemplateUtils.getClient();
		String response = restTemplate.postForObject(url, null, String.class, params);
		return response;
	}

}
