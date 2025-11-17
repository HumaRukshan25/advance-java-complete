<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Employees - Management System</title>
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

        button {
            padding: 8px 12px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        a button {
            text-decoration: none;
        }

        #add-record {
            margin-left: 75%;
            margin-bottom: 20px;
            display: inline-block;
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

    <h1 style="text-align: center;">Employee Records</h1>
    <a href="employee" id="add-record"><button>Add New Employee</button></a>

    <table>
        <thead>
            <tr>
                <th>Employee Name</th>
                <th>Department</th>
                <th>Add Address</th>
                <th>View Addresses</th>
               
                <th colspan="2">Action</th>
            </tr>
        </thead>
       <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td><a href="addAddress?employeeId=${employee.id}"><button>Add Address</button></a></td>
                    <td><a href="viewAddress?employeeId=${employee.id}"><button>View Addresses</button></a></td>
                     <td>
                <!-- Update Button -->
                <a href="editEmployee?id=${employee.id}">
                    <button>Update</button>
                </a>
            </td>
            <td>
                <!-- Delete Button with Confirmation -->
                <a href="deleteEmployee?id=${employee.id}" 
                   onclick="return confirm('Are you sure you want to delete this employee?');">
                    <button style="background-color: red;">Delete</button>
                </a>
            </td>
                </tr>
            </c:forEach>
        </tbody> 
        
        
    </table>
</body>
</html>
