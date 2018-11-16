package com.liangzhelang.controller;

import com.liangzhelang.entity.Sentence;
import com.liangzhelang.service.ReadingService;
import com.liangzhelang.util.Encoding;
import com.liangzhelang.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
public class ReadingController {
	private static Logger LOGGER = LoggerFactory.getLogger(ReadingController.class);

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
			LOGGER.info("默认进入阅读页面的第一页");
			return "redirect:/reading?currPage=1";
		}
		LOGGER.info("进入阅读页面");
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

		// TODO: 2018/11/16 Exception?
		p = readingService.getSentencesInPage(p, sentence);
		LOGGER.info("将分页查询的结果填充进页面，返回到前端");
		return p;
	}
	
	
	
}
