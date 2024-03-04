package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Dept;
import com.sample.vo.Employee;

@Mapper
public interface DeptMapper {

	List<Dept> getAllDepts();
	void insertDept(Dept dept);

}
