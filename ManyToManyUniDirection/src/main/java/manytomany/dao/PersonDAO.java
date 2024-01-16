package manytomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.query.criteria.internal.predicate.ExistsPredicate;

import manytomany.dto.Language;
import manytomany.dto.Person;

public class PersonDAO {
	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pallavi");
		return entityManagerFactory.createEntityManager();
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void saveLanguage(Language language) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(language);
		entityTransaction.commit();
	}
	
	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		Person person2=entityManager.find(Person.class, id);
		if(person2 != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			person.setPid(person2.getPid());
			person.setLanguages(person2.getLanguages());
			entityManager.merge(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person with id "+id+" does not exist.");
		}
	}
	
	public void deletePerson(int id){
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		if(person != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person not Exists with id = "+id);
		}
	}
	
	public void getPersonById(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		System.out.println(person.toString());
		
	}
	
	public void getAllPersons() {
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		System.out.println(query.getResultList());
	}
}
