<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee - Management System</title>
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
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        form button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<h2>${msg1}</h2> 
    <!-- Navigation Bar -->
    <div class="navbar">
        <a href="index.jsp">Home</a>
        <a href="employee">Add Employee</a>
        <a href="employees">View Employees</a>
    </div>

    <div class="container">
        <h2>Add Employee</h2>
        <form action="saveEmployee">
            <input type="text" name="name" placeholder="Enter Employee Name" required>
            <input type="text" name="department" placeholder="Enter Department" required>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
