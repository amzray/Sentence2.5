package com.liangzhelang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/search")
@Controller
public class SearchController {
	private static Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

	@GetMapping
	public String search() {
		LOGGER.info("进入搜索页面");
		return "search";
	}
}
