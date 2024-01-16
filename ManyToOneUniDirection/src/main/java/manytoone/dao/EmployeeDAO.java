package manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone.dto.Employee;

public class EmployeeDAO {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void save(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public void update(int id, Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee2=entityManager.find(Employee.class, id);
		if(employee2!=null) {
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Record not found to update!");
		}
		
	}
	
	public void delete(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee=entityManager.find(Employee.class, id);
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Record not found to delete!");
		}
	}
	
	public void getById(int id) {
		EntityManager entityManager = getEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		if(employee!=null) {
			System.out.println("Record found : " + employee.toString());
		}else {
			System.out.println("Record not found!");
		}
	}
	
	public void getAllEmployees() {
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select e from Employee");
		System.out.println(query.getResultList());
		
	}
}
