<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Form</title>
</head>
<body>
<h1>Patient Form</h1>
<form action="patient">
<label>Id:</label>
<input type="number" name="id" placeholder="enter patient id"><br><br>
<label>Name:</label>
<input type="text"  name="name" placeholder="enter patient name:" ><br><br>
<label>Disease Name:</label>
<input type="text"  name="disease" placeholder="enter disease name:" ><br><br>
<label>Age:</label>
<input type="number"  name="age" placeholder="ente patient age:" ><br><br>
<label>Phone number:</label>
<input type="tel"  name="phone" placeholder="enter phone number:" ><br><br>

<button type="submit">submit patient details</button>
</form>

</body>
</html>