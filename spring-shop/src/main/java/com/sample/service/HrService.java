package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.DeptMapper;
import com.sample.mapper.EmpMapper;
import com.sample.vo.Dept;
import com.sample.vo.Employee;
import com.sample.web.dto.Criteria;
import com.sample.web.dto.ListDto;
import com.sample.web.dto.Pagination;
import com.sample.web.form.DeptCreateForm;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;

@Service
public class HrService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private EmpMapper empMapper;
	
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts();
	}

	public void CreateDept(DeptCreateForm form) {
		Dept dept = Dept.builder()
			.name(form.getName())
			.tel(form.getTel())
			.fax(form.getFax())
			.build();
		
		deptMapper.insertDept(dept);
	}
	
	public List<Employee> getAllEmployees() {
		return empMapper.getAllEmployees();
	}

	public void insertEmployee(EmpCreateForm form) {
		Employee employee = form.toEmployee();
		empMapper.insertEmployee(employee);
	}

	public Employee getEmployeeDetail(int no) {
		return empMapper.getEmployeeDetail(no);
	}

	public void updateEmployee(EmpModifyForm modifyForm) {
		Employee employee = modifyForm.toEmployee();
		empMapper.updateEmployee(employee);
	}

	public void deleteEmployee(int no) {
		empMapper.deleteEmployee(no);
	}

	public ListDto<Employee> getEmployees(Criteria criteria) {
		
		int totalRows = empMapper.getTotalRows(criteria);
		
		Pagination pagination = new Pagination(criteria.getPage(), totalRows, criteria.getRows());
		criteria.setBegin(pagination.getBegin());
		criteria.setEnd(pagination.getEnd());
		
		List<Employee> productList = empMapper.getEmployees(criteria);
		
		ListDto<Employee> dto = new ListDto<Employee>(productList, pagination);
		
		return dto;
	}

}
