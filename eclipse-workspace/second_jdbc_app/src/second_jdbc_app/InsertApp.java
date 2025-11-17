package second_jdbc_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertApp {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			System.out.println("connection created");
			
			Statement s=con.createStatement();
			System.out.println("statement created");
			
			s.execute("insert into emp values(1390,'John',20000,30),(1303,'John',20000,30)");
			System.out.println("statement executed");
			
			int row=s.getUpdateCount();// to process the resultant data
			System.out.println(row+" : Rows affected"); // it will give number of rows affected
			
			s.close();//close all the costly resources like statement and connection
			con.close();
			System.out.println("closed.......");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}