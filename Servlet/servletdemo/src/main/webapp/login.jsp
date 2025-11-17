<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>Login page</h1>
    <form action="login" method="post">
    <!-- using post we can send more data -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"  placeholder="enter name:"  required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"   placeholder="enter password:" required><br><br>

        <input type="submit" value="Login">
    </form>
    
    <hr>
<h1>print page</h1>
 <form action="print" method="get">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"  placeholder="enter your name:"  required><br><br>
        
        <label for="place">Place:</label>
        <input type="text" id="place" name="place"   placeholder="enter your place:" required><br><br>

        <input type="submit" value="print">
    </form>
    <br>
    <hr>
    <hr>
   <h2> <a href="reg.jsp">Click here to register</a></h2>
   <h2> <a href="patient.jsp">Click here to register patient</a></h2>
   <h2><a href="student.jsp">click here for student login</a></h2>
   <h2><a href="info.jsp">click here to go to information page</a></h2>
</body>
</html>