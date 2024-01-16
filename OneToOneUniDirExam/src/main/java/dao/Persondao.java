package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Person;

public class Persondao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		return entityManagerFactory.createEntityManager();
	}
	
	public Person save(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person.getAadharCard());
		entityManager.persist(person);
		entityTransaction.commit();
		return person;
	}
	
	public Person update(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
		return person;
	}
	
	public boolean delete(int id) {
		EntityManager entityManager = getEntityManager();
		Person person=entityManager.find(Person.class, id);
		if(person != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public Person getById(int id) {
		EntityManager entityManager = getEntityManager();
		Person person=entityManager.find(Person.class, id);
		System.out.println(person.toString());
		return person;
	}
	
	public List<Person> getAll(){
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Person p");
		System.out.println(query.getResultList());
		return query.getResultList();
	}
}
