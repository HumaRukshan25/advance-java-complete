<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Addresses - Management System</title>
    <style>
        /* Navigation Bar Styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
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

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        thead {
            background-color: #007bff;
            color: white;
        }

        thead th {
            padding: 10px;
            text-align: left;
            font-size: 1rem;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tbody tr:nth-child(odd) {
            background-color: #ffffff;
        }

        tbody td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        #back-button {
            display: block;
            width: 150px;
            margin: 20px auto;
            text-align: center;
            padding: 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        #back-button:hover {
            background-color: #0056b3;
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

    <h2 style="text-align: center;">Employee Addresses</h2>
    <table>
        <thead>
            <tr>
                <th>Street</th>
                <th>City</th>
                <th>State</th>
                <th>ZIP Code</th>
                 <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="address" items="${addresses}">
                <tr>
                    <td>${address.street}</td>
                    <td>${address.city}</td>
                    <td>${address.state}</td>
                    <td>${address.zip}</td>
                    <td>
                <!-- Update Button -->
                <a href="editAddress?id=${address.id}">
                    <button style="background-color: #28a745; color: white;">Update</button>
                </a>
            </td>
            <td>
                <!-- Delete Button with Confirmation -->
                <a href="deleteAddress?id=${address.id}" 
                   onclick="return confirm('Are you sure you want to delete this address?');">
                    <button style="background-color: red; color: white;">Delete</button>
                </a>
            </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a id="back-button" href="employees">Back to Employees</a>
</body>
</html>
