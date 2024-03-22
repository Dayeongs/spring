package com.sample.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.service.SampleService;
import com.sample.vo.Employee;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="API", description = "Sample API 입니다.")
@RestController
@RequestMapping("/api")
public class SampleController {

	@Autowired
	private SampleService sampleService;
	
	@PostMapping("/getUser/{no}")
	public Employee getUser(@Parameter(description = "번호") @PathVariable("no") int no) {
		return sampleService.getUser(no);
	}
	
}

