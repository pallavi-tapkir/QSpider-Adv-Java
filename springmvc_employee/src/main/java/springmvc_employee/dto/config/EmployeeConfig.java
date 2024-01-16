package springmvc_employee.dto.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "springmvc_employee")
public class EmployeeConfig {
	@Bean //to create object of third party classes 
	public EntityManager getEntityManager() {
		EntityManagerFactory eManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		return eManagerFactory.createEntityManager();
	}
	
}
