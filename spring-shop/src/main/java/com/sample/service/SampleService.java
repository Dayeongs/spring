package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.EmpMapper;
import com.sample.vo.Employee;

@Service
public class SampleService {
	
	@Autowired
	private EmpMapper empMapper;

	public Employee getUser(int no) {
		return empMapper.getEmployeeDetail(no);
	}

}