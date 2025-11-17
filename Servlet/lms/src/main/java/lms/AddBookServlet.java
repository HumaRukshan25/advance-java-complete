package lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/add",loadOnStartup=0)

public class AddBookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id=req.getParameter("id");
		String name=req.getParameter("name");
	
		String price=req.getParameter("price");
	
		String author=req.getParameter("author");
		

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms" ,"root","root");
			PreparedStatement ps=con.prepareStatement("insert into books values(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
		
			ps.setDouble(3, Double.parseDouble(price));
			ps.setString(4, author);
			
			int row=ps.executeUpdate();
			System.out.println(row +" : row affected");
			ps.close();
			con.close();
			
			PrintWriter pw=resp.getWriter();
			pw.write("<html><body> <h1 id='msg'>book added successful  </h1></body> </html>");	
			
			
//			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			
			RequestDispatcher rd=req.getRequestDispatcher("addbook.jsp");
			rd.include(req, resp);
			
			} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}

	

}

