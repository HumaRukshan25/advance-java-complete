package servletdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; // to do map request and the  actual resource
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hi")

public class OurServlet extends HttpServlet{
	public OurServlet(){
		System.out.println("OurServlet Constructor");	
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Our Servlet init() method");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("Our servlet Class.... doGet() method");
	
	}
	
	// to get doPost request we have to give in form method ="post"
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("Our servlet Class.... doPost() method");
	}

	// if we use both doget and service in httpservlet then service will execute
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("OurServlet Class.... service() method");
//	}
	@Override
	public void destroy() {
		System.out.println("OurServlet  destroy() method");
	}

}
