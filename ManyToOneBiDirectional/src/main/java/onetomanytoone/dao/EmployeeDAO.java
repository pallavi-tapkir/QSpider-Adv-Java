package onetomanytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanytoone.dto.Company;
import onetomanytoone.dto.Employee;

public class EmployeeDAO {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		return entityManagerFactory.createEntityManager();
	}
	
	public void save(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company company = employee.getCompany();
		Company curCompany = entityManager.find(Company.class, company.getId());
		entityTransaction.begin();
		if(curCompany == null) {
			entityManager.persist(company);
		}
		entityManager.persist(employee);
		entityTransaction.commit();
	}
}
