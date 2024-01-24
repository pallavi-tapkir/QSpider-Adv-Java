package com.jsp.paginationapi_task1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jsp.paginationapi_task1.dto.Employee;
import com.jsp.paginationapi_task1.service.EmployeeService;

@SpringBootApplication
public class PaginationapiTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(PaginationapiTask1Application.class, args);
	}

	@Bean
	  public CommandLineRunner demo(EmployeeService employeeService) {
	    return (args) -> {
	      // save few employee
	      Employee emp1 = new Employee();
	      emp1.setName("Adam");
	      emp1.setDesign("Developer");
	      Employee emp2 = new Employee();
	      emp2.setName("Robert");
	      emp2.setDesign("Tester");
	      Employee emp3 = new Employee();
	      emp3.setName("John");
	      emp3.setDesign("Designer");
	      Employee emp4 = new Employee();
	      emp4.setName("William");
	      emp4.setDesign("Server Admin");
	      Employee emp5 = new Employee();
	      emp5.setName("Robin");
	      emp5.setDesign("Team Lead");
	      Employee emp6 = new Employee();
	      emp6.setName("Peter");
	      emp6.setDesign("Developer");
	      Employee emp7 = new Employee();
	      emp7.setName("Jack");
	      emp7.setDesign("Tester");
	      Employee emp8 = new Employee();
	      emp8.setName("Sam");
	      emp8.setDesign("SEO Executive");
	      Employee emp9 = new Employee();
	      emp9.setName("Ronnie");
	      emp9.setDesign("Developer");
	      Employee emp10 = new Employee();
	      emp10.setName("Ricky");
	      emp10.setDesign("Project Lead");
	      employeeService.save(emp1);
	      employeeService.save(emp2);
	      employeeService.save(emp3);
	      employeeService.save(emp4);
	      employeeService.save(emp5);
	      employeeService.save(emp6);
	      employeeService.save(emp7);
	      employeeService.save(emp8);
	      employeeService.save(emp9);
	      employeeService.save(emp10);
	    };
	}
}
