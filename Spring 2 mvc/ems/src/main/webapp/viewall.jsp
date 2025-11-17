<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Educations</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f9;
        color: #333;
    }

    table {
        width: 80%;
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

<h1 style="text-align: center;">Education Records</h1>
<a href="savepage" id="add-record"><button>Add New Record</button></a>

<table>
    <thead>
        <tr>
            <th>University</th>
            <th>College/School</th>
            <th>Year of Passing</th>
            <th>CGPA</th>
            <th colspan="2">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="education" items="${educations}">
            <tr>
                <td>${education.uname}</td>
                <td>${education.cname}</td>
                <td>${education.yop}</td>
                <td>${education.cgpa}</td>
                <td><a href="editpage?id=${education.id}"><button>Update</button></a></td>
                <td><a href="delete?id=${education.id}"><button>Delete</button></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Educations - Management System</title>
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

    <h1 style="text-align: center;">Education Records</h1>
    <a href="savepage" id="add-record"><button>Add New Record</button></a>

    <table>
        <thead>
            <tr>
                <th>University</th>
                <th>College/School</th>
                <th>Year of Passing</th>
                <th>CGPA</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="education" items="${educations}">
                <tr>
                    <td>${education.uname}</td>
                    <td>${education.cname}</td>
                    <td>${education.yop}</td>
                    <td>${education.cgpa}</td>
                    <td><a href="editpage?id=${education.id}"><button>Update</button></a></td>
                    <td><a href="delete?id=${education.id}"><button>Delete</button></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>


