<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    #cd{
    margin-left:75%;
    }
    
    
</style>

</head>
<body>
<%-- <%=users %> --%>

${users} 
<h1>User List</h1>
<a href="regpage" id="cd"><button>Create Account</button></a>

<table>
<thead>
<tr>
<!-- <th>Id</th> -->
<th>name</th>
<th>email</th>
<th>Phone</th>
<th>age</th>
<!-- <th>password</th> -->
<th colspan="2">Action</th>

</tr>
</thead>

<tbody>

<c:forEach var="u" items="${users}"> <!-- u is object users is list -->
<tr>
<%-- <td>${u.getId()}</td> --%>
<td>${u.getName()}</td>
<td>${u.getEmail()}</td>
<td>${u.getPhone()}</td>
<td>${u.getAge()}</td>
<%-- <td>${u.getPassword()}</td> --%>
<td><a href="updatepage?id=${u.getId()}"><button>update</button></a></td>
<td><a href="delete?id=${u.getId()}"><button>delete</button></a></td>


</tr>
</c:forEach>
</tbody>

</table>

</body>
</html>