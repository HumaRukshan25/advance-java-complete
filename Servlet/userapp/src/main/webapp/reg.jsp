<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Page</h1>
    <form action="register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="enter name:" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email"  placeholder="enter email:" required><br><br>

        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" pattern="[0-9]{10}"  placeholder="enter phno:" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"  placeholder="enter password:" required><br><br>

        <button type="submit">Register</button>
    </form>

</body>
</html>