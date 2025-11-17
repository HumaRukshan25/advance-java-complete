package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// from codeshare.io sir shared code to create account in company database application

public class App {
	public static void main(String[] args) {
		while(true) {

			System.out.println("Select Option");
			System.out.println("1) Create Account");
			System.out.println("2) Update Account");
			System.out.println("3) Display All Accounts");
			System.out.println("4) Delete Account");
			System.out.println("5) Exit");
			switch (new Scanner(System.in).nextInt()) {
			case 1:
				insert(); 
				break; 
			case 2:
				updateSalById();
				break;
			case 3:
				selectAll();
				break;
			case 4:
				deleteById();
				break;
			case 5:
				System.exit(0);
				break;

			default:System.out.println("Invalid Choice");
				break;
			}

		}
	}

	static void insert() {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into emp values (?,?,?,?)");

			System.out.println("Enter Id : ");
			int id = sc.nextInt();

			System.out.println("Enter Name : ");
			String name = sc.next();

			System.out.println("Enter Sal : ");
			double sal = sc.nextDouble();

			System.out.println("Enter DNo : ");
			int dNo = sc.nextInt();

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, sal);
			ps.setInt(4, dNo);
			int row = ps.executeUpdate();
			System.out.println(row + " : Rows Affected...");
			ps.close();
			con.close();
			System.out.println("Done...");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void updateSalById() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
			PreparedStatement ps = con.prepareStatement("update emp set sal=? where id = ?");
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Updated Sal");
			double sal = sc.nextDouble();

			System.out.println("Enter Id : ");
			int id = sc.nextInt();

			ps.setDouble(1, sal);
			ps.setInt(2, id);

			int row = ps.executeUpdate();

			System.out.println(row + " : Row Affected...");
			ps.close();
			con.close();
			System.out.println("*******Done******");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	static void deleteById() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Id to Delete : ");
			int id = sc.nextInt();
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			System.out.println(row + " : Row Affected...");
			ps.close();
			con.close();
			System.out.println("*******Done******");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void selectAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
			Statement s = con.createStatement();
			boolean b = s.execute("select * from emp");
			if (b == true) {
				ResultSet rs = s.getResultSet();
				int c = 1;  
				// c is the columnindex  like rs.getInt(int columnindex)
				
				while (rs.next()) {
					System.out.print(rs.getInt(1) + "\t");
					System.out.print(rs.getString(2) + "\t");
					System.out.print(rs.getDouble(3) + "\t");
					System.out.println(rs.getInt(4));
				}
				rs.close();
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
