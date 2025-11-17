package pmms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/allpatient")

public class FetchAllPatientServlet extends HttpServlet{
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pmms","root","root");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from patient");
			
			req.setAttribute("rs", rs);
			
			RequestDispatcher rd=req.getRequestDispatcher("allpatient.jsp");
			rd.forward(req,resp);
			
				
		rs.close();
			s.close();
			con.close();
	
			
		} catch (ClassNotFoundException |SQLException e) {
			
			e.printStackTrace();
		}
	}

}
