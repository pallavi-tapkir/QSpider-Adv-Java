package com.jsp.paginationapi_task1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.paginationapi_task1.dto.Employee;
import com.jsp.paginationapi_task1.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees/{pageNumber}/{pageSize}")
	public List<Employee> getEmployees(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
		Page<Employee> data = employeeService.getEmployeePagination(pageNumber, pageSize, null);
		return data.getContent();
	}
	
	@GetMapping("/employees/{pageNumber}/{pageSize}/{sort}")
	public List<Employee> getEmployees(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @PathVariable String sort){
		Page<Employee> data = employeeService.getEmployeePagination(pageNumber, pageSize, sort);
		return data.getContent();
	}
}
