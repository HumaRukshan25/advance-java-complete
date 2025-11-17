package org.jsp.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        long phone = Long.parseLong(req.getParameter("phone"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");

//        System.out.println(id + " " + name + " " + email + " " + phone + " " + username + " " + password);

        PreparedStatement ps = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "root");
            ps = con.prepareStatement("insert into std values(?,?,?,?,?,?)"); // Replace table_name with your actual table name
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, username);
            ps.setString(4, email);
            ps.setLong(5, phone);
            ps.setString(6, password);
            int row = ps.executeUpdate();
            System.out.println(row + " row(s) affected");

            PrintWriter pw = resp.getWriter();
            pw.write("<html><body><h3>Registration successful</h3></body></html>");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.include(req, resp);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
