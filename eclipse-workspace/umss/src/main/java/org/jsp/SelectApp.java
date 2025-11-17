package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		Statement s=con.createStatement();
		boolean b=s.execute("select * from emp");
		System.out.println(b);
		if(b==true) {
			ResultSet rs=s.getResultSet();
			int c=1; //columnindex
			while(rs.next()){
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getDouble(3)+"\t");
				System.out.println(rs.getInt(4)+"");
				
			}
			rs.close();	
		}
		s.close();
		con.close();

	}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}

}
}
