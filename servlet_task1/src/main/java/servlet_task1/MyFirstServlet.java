package servlet_task1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFirstServlet extends GenericServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6569421481549882072L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("First servlet called successfully!");
//		res.getOutputStream().print("success");
	}
}
