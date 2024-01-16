package product_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product_servlet.dao.ProductDAO;
import product_servlet.dto.Product;

public class ProductController extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = res.getWriter();
		
		
		ServletContext context = getServletContext();
		Double cgstDouble = Double.parseDouble(context.getInitParameter("cgst"));
		
		ServletConfig servletConfig = getServletConfig();
		double mah = Double.parseDouble(servletConfig.getInitParameter("MAH"));
		double kar = Double.parseDouble(servletConfig.getInitParameter("KAR"));
		
		Double price = Double.parseDouble(req.getParameter("price"));
		
		if(req.getParameter("state").equals("mah")) {
			price = price + ((cgstDouble + mah) * price)/100;
		}
		
		if(req.getParameter("state").equals("KAR")) {
			price = price + ((cgstDouble + kar) * price)/100;
		}
		
		res.getWriter().print("Price = "+ price);
		
		Product product = new Product(req.getParameter("name"), 
				req.getParameter("manufacturer"), 
				req.getParameter("brand"), 
				price, 
				req.getParameter("state"));
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.save(product);
		
		printWriter.print("Success");
	}
}
