package org.jsp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		while(true) {
			System.out.println("select option:");
			System.out.println("1) register/insert:");
			System.out.println("2) update name by id:");
			System.out.println("3) update room no by id:");
			System.out.println("4) update checkoutdate by id:");
			System.out.println("5) update checkindate by id:");
//			System.out.println("6) view all customers");
//			System.out.println("7) view customer by id");
			
			System.out.println("6) delete by id:");
			System.out.println("7) delete by name:");
			System.out.println("8) exit");

			switch(sc.nextInt()) {
			case 1:
				registerCustomer();
				break;
				
			case 2:
				updateName();
				
				break;
			case 3: updateRoomNo();
				break;
			case 4:updateCheckOutDate();
				break;
			case 5:updateCheckInDate();
				break;
			case 6: deleteById();
				break;
			case 7: deleteByName();
			break;
			case 8:System.exit(0);
				default:System.out.println("invalid choice");
				break;
			}
		}
	}
	
	static Scanner sc=new Scanner(System.in);
	
	static void registerCustomer() {
		System.out.println("enter customer id:");
		int id=sc.nextInt();
		
		System.out.println("enter name:");
		String name=sc.next();
		
		System.out.println("enter checkin date:");
		String checkInDate=sc.next();
		
		System.out.println("enter the checkout date:");
		String checkOutDate=sc.next();
		
		System.out.println("enter roomno:");
		int roomNo=sc.nextInt();
		
		System.out.println("enter amount");
		double amount=sc.nextDouble();
		
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
			 ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDate(3, Date.valueOf(checkInDate));
			ps.setDate(4, Date.valueOf(checkOutDate));
			ps.setInt(5, roomNo);
			ps.setDouble(6, amount);
			
			int row=ps.executeUpdate();
			System.out.println(row+" :row inserted");
			
//			ps.close();
//			con.close();
		
			
		} catch (ClassNotFoundException| SQLException e) {
		
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
			try {
				ps.close();
				
			} catch (SQLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
			}
			if(con!=null) {
		try {
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			// TODO: handle exception
		}
		}
		
	}
//assignment 
 static void updateName() {
		// TODO Auto-generated method stub
	 System.out.println("enter the name to update");
		String name=sc.next();
		 
		 System.out.println("enter the id:");
		 int id=sc.nextInt();
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
			 
			 
			 PreparedStatement ps=con.prepareStatement("update customer set name=? where id=?");
			 

			 
			 ps.setString(1, name);
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
 static void  updateRoomNo() {
	 System.out.println("enter the roomno to update");
		int roomno=sc.nextInt();
		 
		 System.out.println("enter the id:");
		 int id=sc.nextInt();
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
			 
			 
			 PreparedStatement ps=con.prepareStatement("update customer set roomno=? where id=?");
			 

			 
			 ps.setInt(1, roomno);
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
 static void updateCheckOutDate() {
	 System.out.println("enter the checkoutdate to update");
		String checkoutdate=sc.next();
		 
		 System.out.println("enter the id:");
		 int id=sc.nextInt();
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
			 
			 
			 PreparedStatement ps=con.prepareStatement("update customer set checkoutdate=? where id=?");
			 

			 
			 ps.setDate(1, Date.valueOf(checkoutdate));
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
	
static void updateCheckInDate() {
	System.out.println("enter the checkoutdate to update");
	String checkindate=sc.next();
	 
	 System.out.println("enter the id:");
	 int id=sc.nextInt();
	 try{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
		 
		 
		 PreparedStatement ps=con.prepareStatement("update customer set checkindate=? where id=?");
		 

		 
		 ps.setDate(1, Date.valueOf(checkindate));
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
static void deleteById() {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id:");
	int id=sc.nextInt();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
		PreparedStatement ps=con.prepareStatement("delete from customer where id=?");
		ps.setInt(1, id);
		
		int row=ps.executeUpdate();
		System.out.println(row +":rows affected");
		ps.close();
		con.close();
		
	}
	catch(ClassNotFoundException |SQLException e) {
		e.printStackTrace();
		
	}
}
static void deleteByName() {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter name:");
	String name=sc.next();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
		PreparedStatement ps=con.prepareStatement("delete from customer where name=?");
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
