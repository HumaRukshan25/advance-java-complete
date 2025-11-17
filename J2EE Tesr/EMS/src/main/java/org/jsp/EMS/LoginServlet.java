package org.jsp.EMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/login")

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emms","root","root");
			PreparedStatement ps=con.prepareStatement("select * from emp where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			PrintWriter pw=resp.getWriter();
			
			
			if(rs.next()){
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/emms","root","root");
					Statement s=con.createStatement();
					ResultSet rs1=s.executeQuery("select * from emp");
					
					
					pw.write("<html><body><h1> User Login successful</h1></body></html>");
					
					req.setAttribute("rs", rs1);
					RequestDispatcher rd=req.getRequestDispatcher("allemployee.jsp");
					rd.include(req,resp);
					
						
				rs1.close();
					s.close();
					con1.close();
			
					
				} catch (ClassNotFoundException |SQLException e) {
					
					e.printStackTrace();
				}
				RequestDispatcher rd=req.getRequestDispatcher("/allemployee");
				rd.include(req, resp);

				
			}
			
			else {
				pw.write("<html><body><h1> Invalid credientials </h1></body></html>");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
				
				
			}
					
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}

}
