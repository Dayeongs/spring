package com.sample.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(path = "/")
	// 또는 @GetMapping(value = "/")
	// 또는 @GetMapping("/")
	// Model 객체: 뷰페이지에 전달할 값을 담는 객체
	public String home(Model model) {
		model.addAttribute("msg", "홈 페이지 방문을 환영합니다.");
		return "home";
	}

}