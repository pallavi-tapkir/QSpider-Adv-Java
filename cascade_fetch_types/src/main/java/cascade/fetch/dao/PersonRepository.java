package cascade.fetch.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cascade.fetch.dto.Person;

public class PersonRepository {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		return entityManagerFactory.createEntityManager();
	}
	
	public void save(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void merge(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
	}
	
	public void delete(Integer id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		if(person != null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person not found.");
		}
	}
	
	public void getPersonById(Integer id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		if(person != null) {
			System.out.println(person.toString());
		}
	}
	
	public void getAllPersons() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		System.out.println(query.getResultList());
	}
}
