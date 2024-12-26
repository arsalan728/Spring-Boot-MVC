package com.employee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.employee.model.EmployeeModel;
import com.employee.service.EmployeeService;




@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
@GetMapping("/form")
public String employeefrom()
{
	return "form";
}
@PostMapping("/save")
public String send(EmployeeModel employeeModel) {
	return "success";
}
//@GetMapping("getallemployees")
//public String getallemployees(Model model) {
//	List<EmployeeEntity>employees=employeeService.getallemployees();
//	model.addAttribute("employees",employees)
  //  return "employee-list";
}


