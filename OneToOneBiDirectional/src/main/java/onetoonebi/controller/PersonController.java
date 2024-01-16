package onetoonebi.controller;

import onetoonebi.dao.PersonDAO;
import onetoonebi.dto.Pancard;
import onetoonebi.dto.Person;

public class PersonController {

	public static void main(String[] args) {
		Person person1 = new Person("Pallavi", "Pune");
		Person person2 = new Person("Bhushan", "Mulkhed");
		
		Pancard pancard1 = new Pancard("Pallavi", "Pune");
		Pancard pancard2 = new Pancard("Bhushan", "Mulkhed");
		
		person1.setPancard(pancard1);
		pancard1.setPerson(person1);
		
		person2.setPancard(pancard2);
		pancard2.setPerson(person2);
		
		PersonDAO personDAO = new PersonDAO();
		personDAO.save(person2);
		
		
////		person2.setAddress("Mulkhed");
////		personDAO.update(2, person2);
//		
//		personDAO.getPersonById(1);
////		personDAO.getAllPersons();
	}

}
