<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees page</title>


</head>
<body>
<h1 align="center">All Employees</h1>


<table border="5"  align="center" cellpadding="10" >

<thead>
<tr>
<th>Name</th>
<th>Email</th>
<th>Salary</th>
<th>Deptno</th>
<th colspan="2">Action</th>
</tr>
</thead>

<%
  ResultSet rs=(ResultSet)request.getAttribute("rs");
while(rs.next()) {
%>
<tr>
<td><%= rs.getString(2) %></td>
<td><%= rs.getString(3) %></td>
<td><%= rs.getString(4) %></td>
<td><%= rs.getString(6) %></td>
<td><a href="delete?id=<%=rs.getString(1)%>"><button>Delete</button></a> </td>
<td><a href="updatepage?id=<%=rs.getString(1) %>"><button>Update</button></a></td>
</tr>

<% 

}
%>
</table>

</body>
</html>