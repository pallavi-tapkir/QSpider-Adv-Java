package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Company;
import dto.Employee;

public class CompanyRepository {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void save(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Employee> employees = company.getEmployees();
		for(Employee employee : employees) {
			entityManager.persist(employee);
		}
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void update(Company company) {
		EntityManager entityManager = getEntityManager();
		
		Company company2 = entityManager.find(Company.class, company.getId());
		if(company2 != null) {
			List<Employee> employees = company2.getEmployees();
			for(Employee employee : employees) {
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityManager.persist(employee);
				entityTransaction.commit();
			}
			entityManager.persist(company);
		}
	}
	
	public void delete(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company company = entityManager.find(Company.class, id);
		List<Employee> employees = company.getEmployees();
		for(Employee employee : employees) {
			entityManager.remove(employee);
		}
		entityManager.remove(company);
		entityTransaction.commit();
	}
	
	public void getById(int id) {
		EntityManager entityManager = getEntityManager();
		Company company = entityManager.find(Company.class, id);
		if(company != null) {
			System.out.println(company.toString());
		}else {
			System.out.println("Company not found with id : "+id);
		}
	}
	
	public void getAll() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select c from company c");
		System.out.println(query.getResultList());
	}
}
