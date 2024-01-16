package jdbc_task1.prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDynamic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id = ");
		int id = scanner.nextInt();
		System.out.println("Enter the name = ");
		String name = scanner.next();
		System.out.println("Enter the salary = ");
		double salary = scanner.nextDouble();
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task2","root", "root");
		PreparedStatement pStatement  = connection.prepareStatement("insert into employee values(?,?,?)");
		pStatement.setInt(1, id);
		pStatement.setString(2, name);
		pStatement.setDouble(3, salary);
		pStatement.execute();
		connection.close();
		System.out.println("Completed");
	}

}
