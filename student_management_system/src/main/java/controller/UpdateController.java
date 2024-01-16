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

@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idString =Integer.parseInt(req.getParameter("id"));
		StudentDAO studentDAO = new StudentDAO();
		Student s =studentDAO.getStudentById(idString);
		if(s != null) {
			req.setAttribute("student", s);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
