package servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegisterServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("hiiiiiiiiiiiii");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(phone);
//		System.out.println(password);
		PrintWriter pw=res.getWriter();
		pw.write("<html>" 
		        + "<h1>" + name + "</h1>" 
				+ "<h1>" + email + "</h1>" 
				+ "<h1>" + phone + "</h1>" 
				+ "<h1>" + password + "</h1>" 		
		        + "</html>");
		
	}

}
