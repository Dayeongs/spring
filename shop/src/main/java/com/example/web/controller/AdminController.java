package com.example.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * ADMIN 권한이 있는 사용자만 이 컨트롤러에 있는 메소드를 호출할 수 있다.
 * @PreAuthorize("hasRole('ROLE_ADMIN')"): 리소스에 대한 접근제어를 한다.
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
	
	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}

}
