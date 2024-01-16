package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student_management_system.dao.StudentDAO;
import student_management_system.dto.Student;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emailString = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.loginStudent(emailString);
		
		if(student.getEmail().equals(emailString) && 
				student.getPassword().equals(password)) {
			List<Student> students = studentDAO.getAllStudents();
			req.setAttribute("list", students);
//			Cookie cookie = new Cookie("username", student.getName());
//			resp.addCookie(cookie);
			
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("username", student.getName());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display");
//			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			req.setAttribute("message", "Please enter valid credentials.");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
