package com.liangzhelang.controller;

import com.liangzhelang.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class IndexController{

	private static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	LoginService loginService;


	@RequestMapping("/index")
	public String first(HttpSession session) {
		//需登录
//		if(session.getAttribute("uid")==null) {
//			return "/unlogin";
//		}
		session.setAttribute("types", loginService.getTypesJson());
		session.setAttribute("langs", loginService.getLangsJson());

		LOGGER.info("在http会话中添加了体裁类型和语言类型列表的数据");
		LOGGER.info("进入索引页面");
		return "index";
	}
	
	
}
