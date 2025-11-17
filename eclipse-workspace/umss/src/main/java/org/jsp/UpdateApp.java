package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 
//		 System.out.println("enter the sal to be updated");
		System.out.println("enter the deptno to update");
		int deptno=sc.nextInt();
		 
		 System.out.println("enter the id:");
		 int id=sc.nextInt();
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			 
//			 PreparedStatement ps=con.prepareStatement("update emp set sal=? where id=?");
			 
			 PreparedStatement ps=con.prepareStatement("update emp set deptno=? where id=?");
			 

			 
			 ps.setInt(1, deptno);
			 ps.setInt(2, id);
			 
			 int row=ps.executeUpdate();
			 System.out.println(row+ ": rows affected");
			 ps.close();
			 con.close();
			 System.out.println("Done.............");
			 
		 
		 
		 }
		 catch(ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		 }
	}

}