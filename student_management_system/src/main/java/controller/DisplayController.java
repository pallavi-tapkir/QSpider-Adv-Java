package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/display")
public class DisplayController extends HttpServlet{
	String name = null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
//		Cookie[] cookies = req.getCookies();
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equals("username")) {
//				name = cookie.getName();
//			}
//		}
		
		HttpSession httpSession = req.getSession();
		String name=(String)httpSession.getAttribute("username");
		if(name!=null) {
			printWriter.print("<h1>WELCOME SESSION!</h1>");
		}else {
			printWriter.print("Login with proper credentials!");
		}
	}
}
