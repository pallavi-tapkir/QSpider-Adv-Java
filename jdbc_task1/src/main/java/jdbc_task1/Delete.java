package jdbc_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task1","root","root");
		Statement statement = connection.createStatement();
		statement.execute("delete from student where sname = 'Trisha'");
		statement.close();
		connection.close();
		System.out.println("Data deleted.");
//		statement.execute("commit");
	}

}
