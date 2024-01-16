package manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import manytomany.dao.PersonDAO;
import manytomany.dto.Language;
import manytomany.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		Person person1 = new Person("Pallavi","Pune");
		Person person2 = new Person("Bhushan","Pune");
		Person person3 = new Person("Jayant","Banglore");
		
		Language language1 = new Language("Marathi","Maharashtra");
		Language language2 = new Language("Hindi","India");
		
		Language language3 = new Language("Malyalam","Banglore");
		Language language4 = new Language("Kanada","Karnataka");
		
		List<Language> languages1 = new ArrayList<Language>();
		languages1.add(language1);
		languages1.add(language2);
		
		List<Language> languages2 = new ArrayList<Language>();
		languages2.add(language2);
		languages2.add(language3);
		
		List<Language> languages3 = new ArrayList<Language>();
		languages3.add(language2);
		languages3.add(language4);
		
		person1.setLanguages(languages1);
		person2.setLanguages(languages2);
		person3.setLanguages(languages3);
		
		PersonDAO personDAO = new PersonDAO();
//		personDAO.saveLanguage(language1);
//		personDAO.saveLanguage(language2);
//		personDAO.saveLanguage(language3);
//		personDAO.saveLanguage(language4);
//		
//		personDAO.savePerson(person1);
//		personDAO.savePerson(person2);
//		personDAO.savePerson(person3);
//		
		
		//update 
		Person person11 = new Person("Bhushan","Mandai");
//		personDAO.updatePerson(2, person11);
		
		personDAO.deletePerson(5);
		personDAO.deletePerson(6);
		
		personDAO.getPersonById(1);
		personDAO.getAllPersons();
	}

}
