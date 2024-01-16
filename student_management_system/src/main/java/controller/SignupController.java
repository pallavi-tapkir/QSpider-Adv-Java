package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_management_system.dao.StudentDAO;
import student_management_system.dto.Student;

@WebServlet("/signup1")
public class SignupController extends HttpServlet {

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Student student = new Student(name, address, email);
		student.setPassword(password);
		
		StudentDAO studentDAO = new StudentDAO();
		Student student2 =studentDAO.save(student);
		if(student2 != null) {
			req.setAttribute("message", "signup successfully!");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}
		
	}
}
