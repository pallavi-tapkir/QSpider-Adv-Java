package onetoonedao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;import org.hibernate.internal.build.AllowSysOut;

import onetoonedto.Pancard;
import onetoonedto.Person;

public class PersonDAO {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void save(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction =entityManager.getTransaction();
		Pancard pancard = person.getPancard();
		entityTransaction.begin();
		if(pancard != null) {
			entityManager.persist(pancard);
		}
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public Person delete(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		if(person != null) {
			Pancard pancard = person.getPancard();
			entityTransaction.begin();
			if(pancard!=null) {
				entityManager.remove(pancard);
			}
			entityManager.remove(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person not found.");
		}
		return person;
	}
	
	public void update(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person2 = entityManager.find(Person.class, person.getId());
		if(person2!= null) {
			entityTransaction.begin();
			Pancard pan =person.getPancard();
			if(pan!=null) {
				entityManager.merge(pan);
			}else {
				entityManager.persist(pan);
			}
			entityManager.merge(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person not found with id : "+person.getId());
		}
	}
	
	public Person getPersonById(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		if(person != null) {
			System.out.println(person.toString());
		}else {
			System.out.println("Person not found with id : "+id);
		}
		return person;
	}
	
	public List<Person> getAllPersons(){
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		List<Person> persons = query.getResultList();
		persons.stream().forEach(e -> System.out.print(e.toString()));
		return persons;
	}
}
