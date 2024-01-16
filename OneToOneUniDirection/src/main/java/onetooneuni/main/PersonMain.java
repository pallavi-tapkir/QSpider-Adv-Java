package onetooneuni.main;

import java.util.List;
import java.util.Scanner;

import onetoonedao.PersonDAO;
import onetoonedto.Pancard;
import onetoonedto.Person;

public class PersonMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		Pancard pancard = new Pancard();
		PersonDAO personDAO = new PersonDAO();
		boolean check = true;
		System.out.println("Person Management");
		
		do {
			System.out.print("\nSelect the operation you wanna perform : ");
			System.out.print("\n1.Save Person");
			System.out.print("\n2.Update Person");
			System.out.print("\n3.Delete Person");
			System.out.print("\n4.Get Person by id");
			System.out.print("\n5.Get all the persons");
			System.out.print("\n6.Exit");
			System.out.print("\nEnter your choice : ");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.print("\nEnter the Person id : ");
				int saveid = scanner.nextInt();
				
				System.out.println("Enter the person name : ");
				String pname = scanner.next();
				
				System.out.println("Enter the address : ");
				String addrSave = scanner.next();
				
				System.out.println("Enter the pancard id : ");
				Integer idIntegerSave = scanner.nextInt();
				
				person.setPancard(pancard);
				
				person.setId(saveid);
				person.setName(pname);
				person.setAddr(addrSave);
				
				pancard.setAddr(addrSave);
				pancard.setId(idIntegerSave);
				pancard.setName(pname);
				
				person.setPancard(pancard);
				personDAO.save(person);
				break;

			case 2:
				System.out.print("\nEnter the Person id : ");
				int updateId = scanner.nextInt();
				
				System.out.println("Enter the person name : ");
				String pnameString = scanner.next();
				
				System.out.println("Enter the address : ");
				String addr = scanner.next();
				
				System.out.println("Enter the pancard id : ");
				Integer idInteger = scanner.nextInt();
				
				person.setPancard(pancard);
				
				person.setId(updateId);
				person.setName(pnameString);
				person.setAddr(addr);
				
				pancard.setAddr(addr);
				pancard.setId(idInteger);
				pancard.setName(pnameString);
				
				person.setPancard(pancard);
				personDAO.update(person);
				break;
				
			case 3:
				System.out.print("\nEnter the Person id : ");
				int deleteId = scanner.nextInt();
				personDAO.delete(deleteId);
				break;
				
			case 4:
				System.out.print("\nEnter the Person id : ");
				int fetchId = scanner.nextInt();
				personDAO.getPersonById(fetchId);
				break;
				
			case 5:
				personDAO.getAllPersons();
				break;
				
			case 6:
				System.exit(0);
				
			default:
				System.out.print("Invalid input.");
				break;
			}
			
			System.out.println("Do you want to continue [true/false] ?  ");
			check = scanner.nextBoolean();
		}while(check);
		
		
	}

}
