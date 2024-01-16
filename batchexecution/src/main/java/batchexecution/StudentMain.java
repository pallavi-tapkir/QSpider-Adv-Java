package batchexecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchexecution","root","root");


		Student student = new Student(4, "Prisha", 100);
		Student student1 = new Student(5, "Ishanvi", 90);
		Student student2 = new Student(6, "Krishna", 95);
		
		List<Student> students = new ArrayList<Student>();
		students.add(student);
		students.add(student1);
		students.add(student2);
		
		PreparedStatement pStatement = connection.prepareStatement("insert into student values(?,?,?)");
		for(Student s : students) {
			pStatement.setInt(1, s.getId());
			pStatement.setString(2, s.getName());
			pStatement.setDouble(3, s.getMarks());
			pStatement.addBatch();
			System.out.println("added the batch");
		}
		pStatement.executeBatch();
		System.out.println("Batch executed successfully");
		
		pStatement.close();
		connection.close();
	}
}
