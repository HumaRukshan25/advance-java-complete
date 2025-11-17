package servletdemo;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StudentServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("welcome to student login");
		String rollno=req.getParameter("rollno");
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String city=req.getParameter("city");
		String address=req.getParameter("address");
		System.out.println(rollno);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(city);
		System.out.println(address);
		
		
	}

}
