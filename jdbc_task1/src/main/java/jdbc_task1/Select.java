package jdbc_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task1","root","root");
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery("select sname, marks from student where id in(200)");
		while(rSet.next()) {
			System.out.print(rSet.getString("sname") + "  ");
			System.out.print(rSet.getLong("marks"));
			System.out.println();
		}
		System.out.println("completed");
		statement.close();
		connection.close();
	}

}
