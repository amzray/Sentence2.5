package com.liangzhelang.controller;

import com.liangzhelang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class IndexController{

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
		
		
		return "index";
	}
	
	
}
