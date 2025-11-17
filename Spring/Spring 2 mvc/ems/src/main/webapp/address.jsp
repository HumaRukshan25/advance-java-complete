<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Address - Management System</title>
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
        <h2>Add Address</h2>
        <form action="saveAddress">
            <input type="hidden" name="employeeId" value="${employeeId}">
            <input type="text" name="street" placeholder="Enter Street" required>
            <input type="text" name="city" placeholder="Enter City" required>
            <input type="text" name="state" placeholder="Enter State" required>
            <input type="text" name="zip" placeholder="Enter ZIP Code" required>
            <button type="submit">Submit</button>
        </form>
        <a href="employees" class="back-link">Back to Employees</a>
    </div>
</body>
</html>
