package com.example.web.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.UserService;
import com.example.vo.User;
import com.example.web.dto.UserDto;

import lombok.RequiredArgsConstructor;

/*
 * ADMIN 권한이 있는 사용자만 이 컨트롤러에 있는 메소드를 호출할 수 있다.
 * @PreAuthorize("hasRole('ROLE_ADMIN')"): 리소스에 대한 접근제어를 한다.
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminController {
	
	private final UserService userService;
	
	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	@GetMapping("/users")
	public String users(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "admin/users";
	}

	@GetMapping("/users/{userId}")
	@ResponseBody
	public UserDto user(@PathVariable("userId") String userId) {
		User user = userService.getUser(userId);
		UserDto dto = new UserDto();
		
		// user의 데이터를 변수명이 같은것끼리 dto에 복사해준다.
		BeanUtils.copyProperties(user, dto);
		
		return dto;
	}
	
}
