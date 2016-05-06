package com.wechat.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.commons.entity.User;
import com.wechat.constant.WechatConstant;

public class LoginFilter implements Filter {

	private Pattern unfilteredURIs = null;

	@Override
	public void destroy() {
		this.unfilteredURIs = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 如果访问的是admin目录下的路径则判断是否登陆 如果未登陆则重定向到登陆页面
		HttpServletRequest requestServletRequest = (HttpServletRequest) request;
		boolean match = unfilteredURIs.matcher(requestServletRequest.getRequestURI()).matches();
		if (match) {
			User user = (User) requestServletRequest.getSession().getAttribute(WechatConstant.LOGIN_FLAG);
			if (user != null && user.getId() != null) {
				chain.doFilter(request, response);
			} else {
				HttpServletResponse requestServletResponse = (HttpServletResponse) response;
				requestServletResponse.sendRedirect("/index");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// 需要过滤admin目录下的登陆权限
		this.unfilteredURIs = Pattern.compile("\\w*/admin/\\w*");
	}
}
