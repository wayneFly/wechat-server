package com.wechat.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wechat.commons.entity.User;
import com.wechat.constant.WechatConstant;

/**
 * @项目名称：wechat-server
 * @类名称：LoginController
 * @类描述：
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView login(User user) {
		ModelAndView md = new ModelAndView();

		return md;
	}

	@RequestMapping("/logout")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView md = new ModelAndView();
		request.getSession().removeAttribute(WechatConstant.LOGIN_FLAG);
		md.setViewName("index");
		return md;
	}
}
