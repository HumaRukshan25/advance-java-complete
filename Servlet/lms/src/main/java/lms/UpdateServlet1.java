package lms;

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

@WebServlet(urlPatterns="/update")

public class UpdateServlet1  extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		
		double price=Double.parseDouble(req.getParameter("price"));
		
		String author=req.getParameter("author");
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
		PreparedStatement ps=con.prepareStatement("update books set name=?,price=?,author=? where id=?");
		
		ps.setString(1,name);
		ps.setDouble(2, price);
		ps.setString(3,author);
		ps.setInt(4, id);
		
		
		int row=ps.executeUpdate();
		System.out.println(row +"Row updated");
		ps.close();
		con.close();
		
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		PrintWriter pw=resp.getWriter();
		pw.write("<html><body><h1>books updated sucessfully </h1></body></html>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from books");
			
			req.setAttribute("rs", rs);
			
			RequestDispatcher rd=req.getRequestDispatcher("allbook.jsp");
			rd.include(req,resp);
			

				
		rs.close();
			s.close();
			con.close();

			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		}


}
