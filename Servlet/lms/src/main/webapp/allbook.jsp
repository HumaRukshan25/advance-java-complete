<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Books Page</title>
</head>
<body>
    <h1 style="text-align:center">All Books</h1>
    <a id="createbut" href="addbook.jsp"><button>add book</button></a><br><br>

    <table border="5" align="center" cellpadding="10" rules="all">
        <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>price</th>
                <th>author</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                ResultSet rs = (ResultSet) request.getAttribute("rs");
                if (rs != null) { // Check if the ResultSet is not null
                    while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt(1) %></td>
                <td><%= rs.getString(2) %></td>
                <td><%= rs.getDouble(3) %></td>
                <td><%= rs.getString(4) %></td>
                <td><a href="delete?id=<%= rs.getInt(1) %>"><button>Delete</button></a></td>
                <td><a href="updatepage?id=<%= rs.getInt(1) %>"><button>Update</button></a></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6" style="text-align:center;">No data available</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <br><br>
    <hr>
    <center><a href='logout'><button>Logout</button></a></center>

    <script type="text/javascript">
        const msgEle = document.getElementById("msg");
        setTimeout(() => {
            if (msgEle) {
                msgEle.style.display = "none";
            }
        }, 2000);
    </script>
</body>
</html>
