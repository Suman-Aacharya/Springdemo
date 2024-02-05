package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.model.Employee;
import com.bway.springproject.service.DepartmentService;
import com.bway.springproject.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	
	@GetMapping("/employee")
	public String getEmployee(Model model) {
		
		model.addAttribute("dList", deptService.getAllDepts());
		return "EmployeeForm";
	}
	
	
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee emp) {
		
		empService.addEmployee(emp);
		
		return "EmployeeForm";
	}

	@GetMapping("/employeeList")
	public String getEmp(Model model) {
		
		model.addAttribute("eList", empService.getAllEmp());
		
		
	return "EmployeeListForm";
	}
	
	@GetMapping("/emp/delete")
	public String deleteEmp(@RequestParam long id) {
		
		empService.deleteEmployee(id);
		
		return "redirect:/employeeList";
	}
	
	@GetMapping("/emp/edit")
	public String editEmp(@RequestParam long id, Model model) {
		
		model.addAttribute("eModel", empService.getEmpById(id));
		model.addAttribute("dList",deptService.getAllDepts());
		
		return "EmployeeEditForm";
	}
	
	@PostMapping("/emp/update")
	public String updateEmp(@ModelAttribute Employee emp) {
		
		empService.update(emp);
		return "redirect:/employeeList";
	}
}
