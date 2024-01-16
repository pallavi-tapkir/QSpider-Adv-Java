package onetomanytoone.controller;

import onetomanytoone.dao.EmployeeDAO;
import onetomanytoone.dto.Company;
import onetomanytoone.dto.Employee;

public class EmployeMain {

	public static void main(String[] args) {
		Employee e1 = new Employee("Pallavi", 1000000);
		Employee e2 = new Employee("Bhushan", 1000000);
		
		Company company = new Company("Bhupal", "Pune");
		e1.setCompany(company);
		e2.setCompany(company);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.save(e1);
		employeeDAO.save(e2);
	}

}
