package controller;

import dao.Persondao;
import dto.AadharCard;
import dto.Person;

public class PersonController {

	public static void main(String[] args) {
		Persondao persondao = new Persondao();
		
		Person person = new Person("Pallavi", "Pune");
		AadharCard aadharCard = new AadharCard("Pallavi", "Pune");
		person.setAadharCard(aadharCard);
		persondao.save(person);

		Person person1 = new Person("Bhushan", "Banglore");
		AadharCard aadharCard1 = new AadharCard("Bhushan", "Banglore");
		person1.setAadharCard(aadharCard1);
		persondao.save(person1);
		
		Person person2 = new Person("Amit", "UP");
		AadharCard aadharCard2 = new AadharCard("Amit", "UP");
		person2.setAadharCard(aadharCard2);
		persondao.save(person2);
		
		person1.setPid(2);
		person1.setAddress("Pune");
		persondao.update(person1);
		
		persondao.delete(3);
		
		persondao.getById(1);
		
		persondao.getAll();
	}

}
