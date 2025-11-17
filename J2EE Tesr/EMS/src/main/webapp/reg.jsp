<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
</head>
<body>
<h1 align="center">Register here</h1>
<form action="reg" align="center" method="post">
<input type="number" name="id" placeholder="enter id"/><br><br>
<input type="text" name="name" placeholder="enter name"/><br><br>
<input type="text" name="email" placeholder="enter email"/><br><br>
<input type="number" name="sal" placeholder="enter salary"/><br><br>
<input type="text" name="password" placeholder="enter password"/><br><br>
<input type="number" name="dno" placeholder="enter deptno"/><br><br>
<input type="submit" name="register" value="Register"/>

</form>
<br><br>
<h3 align="center"><a href="login.jsp">already have account click here to login </a></h3>
</body>
</html>