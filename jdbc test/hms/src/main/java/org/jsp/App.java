package org.jsp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		while(true) {
			System.out.println("select:");
			System.out.println("1) register:");
			System.out.println("2) update disease by id:");
			System.out.println("3) update  the age by phone number");
			System.out.println("4) view all patient records");
			System.out.println("5) view patient by phone number");
			System.out.println("6) search patients by disease");
			System.out.println("7) search  patient by name");
			System.out.println("8) delete by patient by phone number and name:");
			
		
int n=sc.nextInt();
			switch(n) {
			case 1:
				registerPatient();
				break;
			
			case 2:
				updateDisease();
				break;

			case 3: updateAge();
				break;
			case 4:viewAll();
				break;
			case 5:viewPatientByPhno();
				break;
			case 6: searchByDisease();
				break;
			case 7: searchByName();
			break;
			case 8:deleteByNamePhon();
			break;
				default:System.out.println("invalid choice");
				break;
			}
		}
	}
	
	static Scanner sc=new Scanner(System.in);
	
	static void registerPatient() {
		System.out.println("enter  id:");
		int id=sc.nextInt();
		
		System.out.println("enter name:");
		String name=sc.next();
		
		System.out.println("enter age:");
		int age=sc.nextInt();
		
		System.out.println("enter phno:");
		long phno=sc.nextLong();
		
		System.out.println("enter disease:");
		String disease=sc.next();
		
		System.out.println("admissiondate enter");
		String admission_date=sc.next();
		
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			 ps=con.prepareStatement("insert into patient values(?,?,?,?,?,?)");
	
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setLong(4,phno);
			ps.setString(5, disease);
			ps.setDate(6, Date.valueOf(admission_date));//2024-09-07 in this format
			
			
			int row=ps.executeUpdate();
			System.out.println(row+" :row inserted");
			
			
		} catch (ClassNotFoundException| SQLException e) {
		
			e.printStackTrace();
		}
		
	}
//
 static void updateDisease() {
		// TODO Auto-generated method stub
	 System.out.println("enter the disease to update");
		String disease=sc.next();
		 
		 System.out.println("enter the id:");
		 int id=sc.nextInt();
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			 
			 
			 PreparedStatement ps=con.prepareStatement("update patient set disease=? where id=?");
			 

			 
			 ps.setString(1, disease);
			 ps.setInt(2, id);
			 
			 int row=ps.executeUpdate();
			 System.out.println(row+ ": rows affected");
			 ps.close();
			 con.close();
			 System.out.println("Done.");
			 
		 
		 
		 }
		 catch(ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		 }
		
	}
 static void  updateAge() {
	 System.out.println("enter the age to update");
		int age=sc.nextInt();
		 
		 System.out.println("enter the phno:");
		 long phno=sc.nextLong();
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			 
			 PreparedStatement ps=con.prepareStatement("update patient set age=? where phone=?");
			 

			 
			 ps.setInt(1, age);
			 ps.setLong(2, phno);
			 
			 int row=ps.executeUpdate();
			 System.out.println(row+ ": rows affected");
			 ps.close();
			 con.close();
			 System.out.println("completed");
			 
		 
		 
		 }
		 catch(ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		 }
	 
 }
 static void viewAll() {
	
		 
		
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			Statement s=con.createStatement();
			boolean b=s.execute("select * from patient");
			System.out.println(b);
			if(b==true) {
				ResultSet rs=s.getResultSet();
				int c=1;
				while(rs.next()){
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getInt(3)+"\t");
					System.out.println(rs.getLong(4)+"");
					System.out.print(rs.getString(5)+"\t");
					System.out.print(rs.getString(6)+"\t");
					
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
	
static void viewPatientByPhno() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		PreparedStatement ps=con.prepareStatement("select *from patient where  phone=?");
		System.out.println("enter phoneno:");
				ps.setString(1, new Scanner(System.in).next());
				
			ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getInt(3)+"\t");
			System.out.println(rs.getLong(4)+"");
			System.out.print(rs.getString(5)+"\t");
			System.out.println(rs.getString(6)+"\t");
			
		}
		rs.close();
			
//		}
		ps.close();
		con.close();
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	 
 }

static void searchByDisease() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");

		PreparedStatement ps=con.prepareStatement("select *from patient where  disease=?");
		System.out.println("enter disease:");
				ps.setString(1, new Scanner(System.in).next());

			ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getInt(3)+"\t");
			System.out.println(rs.getLong(4)+"");
			System.out.print(rs.getString(5)+"\t");
			System.out.println(rs.getString(6)+"\t");
			
		}
		rs.close();
			

		ps.close();
		con.close();
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

static void searchByName() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");

		PreparedStatement ps=con.prepareStatement("select *from patient where  name=?");
		System.out.println("enter name:");
				ps.setString(1, new Scanner(System.in).next());

			ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getInt(3)+"\t");
			System.out.println(rs.getLong(4)+"");
			System.out.print(rs.getString(5)+"\t");
			System.out.println(rs.getString(6)+"\t");
			
		}
		rs.close();
			

		ps.close();
		con.close();
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

static void deleteByNamePhon() {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter name:");
	String name=sc.next();
	System.out.println("enter phone number");
	Long phno=sc.nextLong();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		PreparedStatement ps=con.prepareStatement("delete from patient where name=? and phone=?");
		ps.setString(1, name);
		ps.setLong(2, phno);
		
		
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
