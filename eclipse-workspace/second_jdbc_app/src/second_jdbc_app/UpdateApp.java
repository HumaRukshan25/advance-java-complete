package second_jdbc_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateApp {
	

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

            // Create a statement
            Statement s = con.createStatement();

            // Execute the update query (update name where id is 1)
            int row = s.executeUpdate("UPDATE emp SET name='allen12344' WHERE id=101");

            // Print the number of affected rows
            System.out.println(row + " : Rows Affected...");

            // Close the statement and connection
            s.close();
            con.close();

            System.out.println("Done...");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}