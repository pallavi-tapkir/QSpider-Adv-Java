package com.jsp.paginationapi_task1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.paginationapi_task1.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
