package com.liangzhelang.controller;

import com.liangzhelang.entity.Sentence;
import com.liangzhelang.service.ReadingService;
import com.liangzhelang.util.Encoding;
import com.liangzhelang.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
public class ReadingController {
	
	@Autowired
	private ReadingService readingService;
	
	private static Integer readingPageSize = 5;

	//阅读页
	@RequestMapping(value = "/reading", method = GET)
	public String reading(HttpSession session,
			@RequestParam(required=false) Integer currPage,
			@RequestParam(required=false) String order,
			@RequestParam(required=false) String author,
			@RequestParam(required=false) String works,
			@RequestParam(required=false) String text,
			@RequestParam(required=false) Integer LanguageId,
			@RequestParam(required=false) Integer TypeId) {
		//需登录
//		if(session.getAttribute("uid")==null) {
//			return "/unlogin";
//		}
		//没有cuurPage请求参数时（从索引跳转来）默认跳转到第一页
		if(currPage==null) {
			return "redirect:/reading?currPage=1";// TODO: 2018/11/15 重定向有所不同？
		}
		return "reading";
	}

	//分页阅读
	@RequestMapping(value="/rp")
	@ResponseBody
	public Page<Sentence> readingPage(
			@RequestParam Integer currPage, 
			@RequestParam(required=false) String order,
			@RequestParam(required=false) String author,
			@RequestParam(required=false) String works,
			@RequestParam(required=false) String text,
			@RequestParam(required=false) Integer languageId,
			@RequestParam(required=false) Integer typeId) throws UnsupportedEncodingException {
		
		Sentence sentence = new Sentence();
		if(author!=null&&author!="") {
			sentence.setAuthor(Encoding.encodeUTF8(author));
		}
		if(works!=null&&works!="") {
			sentence.setWorks(Encoding.encodeUTF8(works));
		}
		if(text!=null&&text!="") {
			sentence.setText(Encoding.encodeUTF8(text));
		}
		//前端传值为0时表示不限数据库中的值
		if(languageId!=null&&languageId!=0) {
			sentence.setLanguageId(languageId);
		}
		//前端传值为0时表示不限数据库中的值
		if(typeId!=null&&typeId!=0) {
			sentence.setTypeId(typeId);
		}

		Integer totalRecord = readingService.getSentencesCount(sentence);
		Page<Sentence> p = new Page<Sentence>(currPage, readingPageSize, totalRecord);
		
		return readingService.getSentencesInPage(p, sentence);
	}
	
	
	
}
