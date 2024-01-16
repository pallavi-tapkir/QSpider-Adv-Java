package person_jdbc;

import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the person id = ");
		int id = scanner.nextInt();
		
		System.out.println("Enter the name of the person = ");
		String name = scanner.next();
		
		System.out.println("Enter the address = ");
		String address = scanner.next();
		
		Person person = new Person(id, name, address);
		PersonCRUD crud = new PersonCRUD();
		crud.save(person);

	}

}
