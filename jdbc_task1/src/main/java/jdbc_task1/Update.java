package jdbc_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task1", "root", "root");
		Statement statement = con.createStatement();
		int count = statement.executeUpdate("update student set marks = 92 where sname='Pallavi'");
		System.out.println(count +" rows got affected.");
		statement.close();
		con.close();
	}

}
