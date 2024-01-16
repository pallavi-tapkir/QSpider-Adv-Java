package person_jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class PersonCRUD {
	
	public Connection getConnection() throws Exception {
		//load or register driver
		//option to Class.forName
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
		
		return connection;
	}
	
	public Person save(Person person) throws Exception {
		Connection connection = getConnection();
		PreparedStatement pStatement = connection.prepareStatement("insert into person values(?,?,?)");
		pStatement.setInt(1, person.getId());
		pStatement.setString(2, person.getName());
		pStatement.setString(3, person.getAddress());
		pStatement.execute();
		connection.close();
		System.out.println("Inserted");
		return person;
	}

	public static void main(String[] args) throws Exception {
		
	}

}
