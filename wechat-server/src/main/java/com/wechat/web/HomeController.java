package com.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.dto.RequestResult;

/**
 * @项目名称：chnsys-rop
 * @类名称：HomeController
 * @类描述：首页
 */
@Controller
public class HomeController {

	@RequestMapping("/index")
	public @ResponseBody RequestResult index() {
		RequestResult result = new RequestResult();
		result.setMessage("哈哈哈哈");
		result.setCode("00000");
		return result;
	}
}
