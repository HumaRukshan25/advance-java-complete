package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectByNameApp {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
//			Statement s=con.createStatement();
			PreparedStatement ps=con.prepareStatement("select *from emp where  name=?");
			System.out.println("enter name:");
					ps.setString(1, new Scanner(System.in).next());
//			ResultSet =ps.executeQuery();
//			boolean b=s.execute("select *from emp where name='huma'");
//			if(b==true) {
				ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+" \t");
				System.out.print(rs.getDouble(3)+"\t");
				System.out.println(rs.getInt(4)+"\t");
			}
			rs.close();
				
//			}
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
