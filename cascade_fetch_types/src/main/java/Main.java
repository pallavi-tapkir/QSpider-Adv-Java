import cascade.fetch.dao.PersonRepository;
import cascade.fetch.dto.Passport;
import cascade.fetch.dto.Person;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person("Pallavi", "Pune");
		Passport passport = new Passport("Pallavi", "Pune");
		person.setPassport(passport);
		
		PersonRepository personRepository = new PersonRepository();
		
		Person person1 = new Person("Test", "Chennai");
		Passport passport1 = new Passport("Test", "Chennai");
		person1.setPassport(passport1);
		
		
		personRepository.save(person);
		personRepository.save(person1);
		
		//cascade for merge
//		person.setId(1);
//		person.setName("Pallavi Bhushan Tapkir");
//		passport.setPid(1);
//		passport.setName("Pallavi Bhushan Tapkir");
//		
//		personRepository.merge(person);
		
//		personRepository.delete(2);
		
		personRepository.getPersonById(1);
		personRepository.getAllPersons();
	}
	
	
}
