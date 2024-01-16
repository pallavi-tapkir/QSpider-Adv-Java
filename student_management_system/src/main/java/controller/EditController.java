package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_management_system.dao.StudentDAO;
import student_management_system.dto.Student;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Student student = new Student(name, address, email);
		student.setId(id);
		student.setPassword(password);
		
		StudentDAO studentDAO = new StudentDAO();
		Student student2=studentDAO.update(student);
		
		if(student2 != null) {
			List<Student> students = studentDAO.getAllStudents();
			req.setAttribute("list", students);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);		
		}
		
	}
}
