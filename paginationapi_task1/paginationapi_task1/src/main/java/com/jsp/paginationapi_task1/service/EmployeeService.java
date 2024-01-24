package com.jsp.paginationapi_task1.service;

import org.springframework.data.domain.Page;

import com.jsp.paginationapi_task1.dto.Employee;

public interface EmployeeService {
	void save(Employee employee);
	Page<Employee> getEmployeePagination(Integer pageNummber, Integer pageSize, String sort);
}
