package controller;

import java.util.List;

import dto.Company;
import dto.Employee;
import repositories.CompanyRepository;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee("Pallavi", 10000000);
		Employee e2 = new Employee("Bhushan", 1000000);
		List<Employee> employees = List.of(e1,e2);
		Company company = new Company("Pallavi", employees);
		
		CompanyRepository companyRepository = new CompanyRepository();
		companyRepository.save(company);
		
//		CompanyRepository
	}

}
