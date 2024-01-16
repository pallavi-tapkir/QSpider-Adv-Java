package manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany.dao.PersonDAO;
import manytomany.dto.Language;
import manytomany.dto.Person;

public class PersonController {

	public static void main(String[] args) {
		Person person1 = new Person("Pallavi", "Pune");
		Person person2 = new Person("Bhushan", "Mulkhed");
		
		Language language1 = new Language("Marathi", "Maharashtra");
		Language language2 = new Language("English", "England");
		
		person1.setLanguages(List.of(language1, language2));
		person2.setLanguages(List.of(language1));
		
		language1.setPersons(List.of(person1, person2));
		language2.setPersons(List.of(person1));
		
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(language1);
		entityManager.persist(language2);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityTransaction.commit();
	}

	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
}
