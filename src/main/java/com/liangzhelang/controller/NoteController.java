package com.liangzhelang.controller;

import com.liangzhelang.entity.Sentence;
import com.liangzhelang.service.NoteService;
import com.liangzhelang.util.MyJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@RequestMapping("/note")
@Controller
public class NoteController {
	private static Logger LOGGER = LoggerFactory.getLogger(NoteController.class);

	@Autowired
	private NoteService noteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String note(HttpSession session) {
		//需登录
//		if(session.getAttribute("uid")==null) {
//			return "/unlogin";
//		}
		LOGGER.info("进入笔记页面");
		return "note";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String notePost(Model model, Sentence s) {
		Integer result = noteService.add(s);

		if(result==1){
			LOGGER.info("成功录入句子");
		}else{// TODO: 2018/11/16 Exception?
			LOGGER.error("未能录入句子");
		}
		LOGGER.info("发送状态码到前端");
		model.addAttribute("status", result);
		LOGGER.info("返回笔记页面");
		return "note";
	}
}
