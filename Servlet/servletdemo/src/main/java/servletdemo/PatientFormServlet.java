package servletdemo;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PatientFormServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("welcome to patient form");
String id=req.getParameter("id");
String name=req.getParameter("name");
String disease=req.getParameter("disease");
String age=req.getParameter("age");
String phone=req.getParameter("phone");
System.out.println(id);
System.out.println(name);
System.out.println(disease);
System.out.println(age);
System.out.println(phone);


		
		
	}

}
