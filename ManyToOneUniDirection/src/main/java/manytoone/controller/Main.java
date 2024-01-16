package manytoone.controller;

import manytoone.dao.CompanyDAO;
import manytoone.dao.EmployeeDAO;
import manytoone.dto.Company;
import manytoone.dto.Employee;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee("Pallavi", 10000.0);
		Employee e2 = new Employee("Bhushan", 10000.0);
		
		Company company = new Company("PreIsha", "Pune");
		e1.setCompany(company);
		e2.setCompany(company);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		CompanyDAO companyDAO = new CompanyDAO();
		
		companyDAO.save(company);
		employeeDAO.save(e1);
		employeeDAO.save(e2);
		
	}

}
