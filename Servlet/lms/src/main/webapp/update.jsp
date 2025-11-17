<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ResultSet rs=(ResultSet)request.getAttribute("rs");
%>
<h1 align="center"> update page</h1>
<form action="update" method="post" align="center">

<input type="number" name="id" placeholder="enter id" value="<%= rs.getInt(1) %>"/><br><br>
<input type="text" name="name" placeholder="enter name" value="<%= rs.getString(2) %>"/><br><br>
<input type="number" name="price" placeholder="enter price" value="<%= rs.getDouble(3) %>"/><br><br>
<input type="text" name="author" placeholder="enter author" value="<%= rs.getString(4) %>"/><br><br>
<input type="submit" name="update"/>

</form>

</body>
</html>