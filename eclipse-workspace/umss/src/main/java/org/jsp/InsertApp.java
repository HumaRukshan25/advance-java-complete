package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id:");
		int id=sc.nextInt();
		System.out.println("enter name:");
		String name=sc.next();
		System.out.println("enter sal:");
		double sal=sc.nextDouble();
		System.out.println("enter Dno:");
		int dNo=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, sal);
			ps.setInt(4, dNo);
			int row=ps.executeUpdate();
			System.out.println(row +" : rows affected");
			ps.close();
			con.close();
			System.out.println("Done....");
			
			
			
		} 
		catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}

}