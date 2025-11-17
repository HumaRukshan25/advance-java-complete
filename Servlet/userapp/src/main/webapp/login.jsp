<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
<h1>Login form</h1>
 <form action="login" method="post">
    <!-- using post we can send more data -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="name"  placeholder="enter name:"  required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"   placeholder="enter password:" required><br><br>

        <input type="submit" value="Login">
    </form>
    

</body>
</html>