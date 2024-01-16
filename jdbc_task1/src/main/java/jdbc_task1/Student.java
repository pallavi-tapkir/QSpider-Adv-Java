package jdbc_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	public static String mySqlDBNameString = "MySQL";
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task1", "root","root");
			Statement stmt = conn.createStatement();
			stmt.execute("insert into student values(6,'Trisha',100)");
			conn.close();
			getDBConnection(mySqlDBNameString);
			System.out.println("Inserted successfully");
			
	}
	
	public static void getDBConnection(String dbName) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		if(dbName.equals(mySqlDBNameString)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task1","root","root");
			Statement statement = connection.createStatement();
			statement.execute("insert into student values(5,'Ishanvi', 100)");
			statement.close();
			connection.close();
		}
	}
}
