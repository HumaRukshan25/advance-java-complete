<%-- 
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Education</title>
</head>
<body>
    <h2>Edit Education Details</h2>
    <form action="edit">
        <input type="hidden" name="id" value="${education.id}">
        <input type="text" name="uname" value="${education.uname}" placeholder="Enter university name" required>
        <input type="text" name="cname" value="${education.cname}" placeholder="Enter college/school name" required>
        <input type="number" name="yop" value="${education.yop}" placeholder="Enter year of passing" required>
        <input type="number" step="0.01" name="cgpa" value="${education.cgpa}" placeholder="Enter CGPA" required>
        <button type="submit">Update</button>
    </form>
    <a href="all">Back to View All</a>
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Education - Management System</title>
    <style>
        /* Navigation Bar Styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .navbar {
            overflow: hidden;
            background-color: #333;
        }
        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .container {
            padding: 20px;
        }
        form input {
            display: block;
            width: 50%;
            padding: 10px;
            margin: 10px 0;
        }
        form button {
            padding: 10px 20px;
            background-color: #ffc107;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        form button:hover {
            background-color: #e0a800;
        }
        .back-link {
            margin-top: 20px;
            display: block;
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <div class="navbar">
        <a href="index.jsp">Home</a>
        <a href="savepage">Add Education</a>
        <a href="all">View Educations</a>
        <a href="employee">Add Employee</a>
        <a href="employees">View Employees</a>
        <a href="about">About</a>
        <a href="contact">Contact</a>
    </div>

    <div class="container">
        <h2>Edit Education Details</h2>
        <form action="edit">
            <input type="hidden" name="id" value="${education.id}">
            <input type="text" name="uname" value="${education.uname}" placeholder="Enter University Name" required>
            <input type="text" name="cname" value="${education.cname}" placeholder="Enter College/School Name" required>
            <input type="number" name="yop" value="${education.yop}" placeholder="Enter Year of Passing" required>
            <input type="number" step="0.01" name="cgpa" value="${education.cgpa}" placeholder="Enter CGPA" required>
            <button type="submit">Update</button>
        </form>
        <a href="all" class="back-link">Back to View All</a>
    </div>
</body>
</html>
