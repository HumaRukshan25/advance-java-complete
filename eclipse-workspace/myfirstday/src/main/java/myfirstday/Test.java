package myfirstday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		try {
//16/06/2025
			Class.forName("com.mysql.cj.jdbc.Driver");//load and register driver class
			System.out.println("Driver class  loaded and  registered");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdayy?user=root&password=root");

			System.out.println("connection established.......");
			
			Statement s=con.createStatement();
			System.out.println("statement created");
			s.execute("insert into emp values(109,'allena',20000)");
			System.out.println("data saved successfully");
			
		}catch(Exception e){
			e.printStackTrace();
			
			
		}
	}
}
