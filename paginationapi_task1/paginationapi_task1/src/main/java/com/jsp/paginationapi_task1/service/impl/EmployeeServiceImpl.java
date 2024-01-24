package com.jsp.paginationapi_task1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jsp.paginationapi_task1.dto.Employee;
import com.jsp.paginationapi_task1.repo.EmployeeRepository;
import com.jsp.paginationapi_task1.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Page<Employee> getEmployeePagination(Integer pageNumber, Integer pageSize, String sort) {
		PageRequest pageable = null;
		if(sort != null) {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sort);
		}else {
			pageable = PageRequest.of(pageNumber, pageSize);
		}
		return employeeRepository.findAll(pageable);
	}

}
