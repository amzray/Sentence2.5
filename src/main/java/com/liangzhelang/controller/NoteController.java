package com.liangzhelang.controller;

import com.liangzhelang.entity.Sentence;
import com.liangzhelang.service.NoteService;
import com.liangzhelang.util.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@RequestMapping("/note")
@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String note(HttpSession session) {
		//需登录
//		if(session.getAttribute("uid")==null) {
//			return "/unlogin";
//		}
		return "note";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String notePost(Model model, Sentence s) {
		System.out.println(MyJson.obj2Str(s));
		Integer result = noteService.add(s);
		model.addAttribute("status", result);
		return "note";
	}
}
