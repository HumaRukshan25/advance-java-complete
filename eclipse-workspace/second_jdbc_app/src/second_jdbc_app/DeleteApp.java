package second_jdbc_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteApp {

    public static void main(String[] args)  {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

            // Create a statement
            Statement s = con.createStatement();

            // Execute the delete query
            int row = s.executeUpdate("DELETE FROM emp WHERE name='John'");

            // Print the number of affected rows
            System.out.println(row + " : Rows Affected...");

            // Close the statement and connection
            s.close();
            con.close();

            System.out.println("Done...");

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
