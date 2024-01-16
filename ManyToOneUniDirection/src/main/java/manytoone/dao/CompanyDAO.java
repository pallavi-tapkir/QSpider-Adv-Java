package manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone.dto.Company;

public class CompanyDAO {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void save(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void update(int id, Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company company2 =entityManager.find(Company.class, id);
		if(company2!= null) {
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
		}else {
			System.out.println("Company doesn't exist!");
		}
	}
	
	public void delete(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company company = entityManager.find(Company.class, id);
		if(company!=null) {
			entityTransaction.begin();
			entityManager.remove(company);
			entityTransaction.commit();
		}else {
			System.out.println("Company doesn't exist for id "+id);
		}
	}
	
	public void getCompanyById(int id) {
		EntityManager entityManager = getEntityManager();
		Company company=entityManager.find(Company.class, id);
		if(company != null) {
			System.out.println(company.toString());
		}else {
			System.out.println("Compant not found.");
		}
	}
	
	public void getAllCompanies() {
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select c from Company");
		System.out.println(query.getResultList());
	}
}