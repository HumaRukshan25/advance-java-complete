package servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InfoServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("welcome to information page");
		String name=req.getParameter("name");
		String place=req.getParameter("place");
		PrintWriter pw=res.getWriter();
		pw.write("<html style='background:cyan'> <h1 style='align:center'> "+ name +  " is from "  + place +"</h1> </html>");
		pw.close();
//		pw.write(place);
		

//		System.out.println(name);
//		System.out.println(place);
		
	}

}
