<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Education</title>
</head>
<body>
    <h2>Enter Education Details</h2>
    <form action="save">
        <input type="text" name="uname" placeholder="Enter university name" required>
        <input type="text" name="cname" placeholder="Enter college/school name" required>
        <input type="number" name="yop" placeholder="Enter year of passing" required>
        <input type="number" step="0.01" name="cgpa" placeholder="Enter CGPA" required>
        <button type="submit">Submit</button>
    </form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Education - Management System</title>
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
        <h2>Add Education Details</h2>
        <form action="save">
        
            <input type="text" name="uname" placeholder="Enter University Name" required>
            <input type="text" name="cname" placeholder="Enter College/School Name" required>
            <input type="number" name="yop" placeholder="Enter Year of Passing" required>
            <input type="number" step="0.01" name="cgpa" placeholder="Enter CGPA" required>
            <button type="submit">Submit</button>
        </form>
    </div>
   
    
    
</form>
    
</body>
</html>

