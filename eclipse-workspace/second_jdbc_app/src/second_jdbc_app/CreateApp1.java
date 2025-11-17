package second_jdbc_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateApp1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			Statement s=con.createStatement();
			 int row=s.executeUpdate("create table student (id INT, name VARCHAR(45), PRIMARY KEY(id))");
			System.out.println(row +"  row affected");
			s.close();
			con.close();
			
		}
		catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}
}