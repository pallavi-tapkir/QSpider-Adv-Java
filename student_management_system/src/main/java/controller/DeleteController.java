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

@WebServlet("/delete")
public class DeleteController  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int idString =Integer.parseInt(req.getParameter("id"));
	StudentDAO studentDAO = new StudentDAO();
	boolean ans = studentDAO.delete(idString);
	if(ans) {
		List<Student> list=studentDAO.getAllStudents();
		req.setAttribute("list", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
		requestDispatcher.forward(req, resp);
	}else {
		
	}
	
}
}
