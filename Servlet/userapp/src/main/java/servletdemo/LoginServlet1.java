package servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// ----------------assignment

public class LoginServlet1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() method of login");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		PrintWriter pw=res.getWriter();
		pw.write("<html>" 
				+"<body> <h1>" + "username is  " + name + " and password is  " + password + "</h1></body>" +"</html>");
		
		
	}

}
