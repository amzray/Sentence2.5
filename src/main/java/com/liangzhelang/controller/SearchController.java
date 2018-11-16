package com.liangzhelang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/search")
@Controller
public class SearchController {
	@GetMapping
	public String search() {
		return "search";
	}
}
