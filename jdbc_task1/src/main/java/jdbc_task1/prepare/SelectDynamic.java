package jdbc_task1.prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectDynamic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id : ");
		int id = scanner.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task2","root","root");
		PreparedStatement pStatement = connection.prepareStatement("select * from employee where id = ?");
		pStatement.setInt(1, id);
		ResultSet rSet = pStatement.executeQuery();
		
		while(rSet.next()) {
			System.out.println("id = "+rSet.getInt(1));
			System.out.println("name = "+rSet.getString(2));
			System.out.println("salary = "+rSet.getDouble(3));
		}
		
		pStatement.close();
		connection.close();
	}

}
