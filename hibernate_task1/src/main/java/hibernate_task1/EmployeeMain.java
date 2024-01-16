package hibernate_task1;

import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		EmployeeCRUD employeeCRUD = new EmployeeCRUD();
		boolean check = true;
		
		do {
			System.out.print("1. save new employee \n2. update existing employee \n3. deleteEmployee"
					+ " \n4. Get Employee by id \n5. Get all employees \nEnter your choice : ");
			int choice = scanner.nextInt();
			
			int id = 0;
			if(choice != 5) {
				System.out.print("\nEnter employee id = ");
				id = scanner.nextInt();
				employee.setId(id);
			}
			
			if (choice == 1 || choice == 2) {
				System.out.print("\nEnter the employee name = ");
				String nameString = scanner.next();
				employee.setName(nameString);
				
				System.out.print("\nEnter the salary = ");
				double salary = scanner.nextDouble();
				employee.setSalary(salary);
			}
			
	
			switch (choice) {
			case 1:
				employeeCRUD.saveEmployee(employee);
				break;

			case 2:
				employeeCRUD.update(employee);
				break;
				
			case 3:
				employeeCRUD.delete(id);
				break;
				
			case 4:
				employeeCRUD.getEmployeeById(id);
				break;
				
			case 5:
				employeeCRUD.getAllEmployees();
				break;
				
			default:
				System.out.println("Invalid input.");
				break;
			}
			
			System.out.print("\nDo you want to continue? :  ");
			check = scanner.nextBoolean();
		}while(check);
		scanner.close();


	}

}