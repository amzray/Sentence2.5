package com.liangzhelang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/nss")
@Controller
public class NoSuchSentenceController {
	private static Logger LOGGER = LoggerFactory.getLogger(NoSuchSentenceController.class);


	@RequestMapping(method=RequestMethod.GET)
	public String noSuchSentence() {
		LOGGER.warn("请求的句子ID没有对应的记录");
		return "noSuchSentence";
	}
}
