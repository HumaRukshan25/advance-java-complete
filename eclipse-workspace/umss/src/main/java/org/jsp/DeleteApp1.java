package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteApp1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name:");
		String name=sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			PreparedStatement ps=con.prepareStatement("delete from emp where name=?");
			ps.setString(1, name);
			
			int row=ps.executeUpdate();
			System.out.println(row +":rows affected");
			ps.close();
			con.close();
			
		}
		catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
		}
	}
}