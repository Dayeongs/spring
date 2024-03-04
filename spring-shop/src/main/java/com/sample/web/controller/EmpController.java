package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.HrService;
import com.sample.vo.Dept;
import com.sample.vo.Employee;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private HrService hrService;
	
	@GetMapping(path = "/list")
	public String list(Model model) {
		List<Employee> empList = hrService.getAllEmployees();
		model.addAttribute("empList", empList);
		
		return "emp/list";
	}
	
	@GetMapping(path = "/add")
	public String form(Model model) {
		List<Dept> deptList = hrService.getAllDepts();
		model.addAttribute("deptList", deptList);
		
		return "emp/form";
	}
	
	@PostMapping(path = "/add")
	public String createEmp(EmpCreateForm form) {
		hrService.insertEmployee(form);
		
		return "redirect:list";
	}
	
	@GetMapping(path = "/detail")
	public String detail(int no, Model model) {
		Employee employee = hrService.getEmployeeDetail(no);
		model.addAttribute("emp", employee);
		
		return "emp/detail";
	}
	
	@GetMapping(path = "/modify")
	public String modifyForm(int no, Model model) {
		List<Dept> deptList = hrService.getAllDepts();
		Employee employee = hrService.getEmployeeDetail(no);
		model.addAttribute("emp", employee);
		model.addAttribute("deptList", deptList);
		
		return "emp/modifyform";
	}
	
	@PostMapping(path = "/modify")
	public String modifyEmp(EmpModifyForm modifyForm) {
		hrService.updateEmployee(modifyForm);
		return "redirect:detail?no=" + modifyForm.getNo();
	}
	
	@GetMapping(path = "/delete")
	public String delete(int no) {
		hrService.deleteEmployee(no);
		return "redirect:list";
	}
	
}
