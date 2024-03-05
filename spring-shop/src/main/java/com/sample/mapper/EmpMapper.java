package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Employee;
import com.sample.web.dto.Criteria;

@Mapper
public interface EmpMapper {
	
	List<Employee> getAllEmployees();
	void insertEmployee(Employee emp);
	Employee getEmployeeDetail(int no);
	void updateEmployee(Employee employee);
	void deleteEmployee(int no);
	int getTotalRows(Criteria criteria);
	List<Employee> getEmployees(Criteria criteria);

}
