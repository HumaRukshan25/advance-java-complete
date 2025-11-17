<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student login</title>
</head>
<body>
<h1>Student login</h1>
<form action="student" method="get">
<label>Student rollno:</label>
<input type="number" name="rollno" placeholder="enter the id for the student"><br><br>
<label>Student name:</label>
<input type="text" name="name" placeholder="enter the name"><br><br>
<label>Phone number:</label>
<input type="tel" name="phone" placeholder="enter the phone number"><br><br>
<label>City:</label>
<input type="text" name="city" placeholder="enter city"><br><br>
<label>address:</label>
<input type="text" name="address" placeholder="enter address"><br><br>

<button type="submit">submit student details</button>
</form>
</body>
</html>