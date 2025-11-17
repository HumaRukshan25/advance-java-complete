package servletdemo;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrintServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//parameter value passed inside getParameter must be same as name given in the form for input ie.. username
String name=req.getParameter("username");
System.out.println(name);
String place=req.getParameter("place");
System.out.println(place);
	}

}
