package onetoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetoonebi.dto.Pancard;
import onetoonebi.dto.Person;

public class PersonDAO {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pallavi");
		return entityManagerFactory.createEntityManager();
	}
	
	public void save(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Pancard pancard = person.getPancard();
		entityTransaction.begin();
		if(pancard != null) {
			entityManager.persist(pancard);
		}
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void update(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		Person person2 = entityManager.find(Person.class, id);
		if(person2 != null) {
			person2.setAddress(person.getAddress());
			person2.setName(person.getName());
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(person2);
			entityTransaction.commit();
		}else {
			System.out.println("Person not found to update!");
		}
	}
	
	public void delete(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		if(person != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person not found!");
		}
	}
	
	public void getPersonById(int id) {
		EntityManager entityManager = getEntityManager();
		Person person=entityManager.find(Person.class, id);
		if(person !=null) {
			System.out.println(person.toString());
		}else {
			System.out.println("Person not found");
		}
	}
	
	public void getAllPersons() {
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		System.out.println(query.getResultList());
	}
}
