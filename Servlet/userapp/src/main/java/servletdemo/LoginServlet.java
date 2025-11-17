package servletdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login",loadOnStartup=1) //loadOnStartUpmust always be non negative

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		System.out.println("login servlet constructor.........");
		
}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		System.out.println("in login servlet do get method");
		
		
}
	
}
