package com.sample.web.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sample.vo.Dept;
import com.sample.vo.Employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpCreateForm {
	
	private String name;
	private String tel;
	private String email;
	private int salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private int deptNo;

	public Employee toEmployee() {
		Dept dept = new Dept();
		dept.setNo(deptNo);
		      
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDept(dept);
		emp.setTel(tel);
		emp.setEmail(email);
		emp.setSalary(salary);
		emp.setHireDate(hireDate);
		      
		return emp;
	}
	
}
