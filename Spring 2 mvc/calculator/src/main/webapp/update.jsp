<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>update user</h1>
<form action="update">
<input type="text"  value="${u.getId()}" name="id" placeholder="enter id:">
<input type="text" value="${u.getName()}" name="name" placeholder="enter name:">
<input type="text" value="${u.getEmail()}" name="email" placeholder="enter email:">
<input type="text" value="${u.getPhone()}"  name="phone" placeholder="enter phone:">
<input type="text" value="${u.getAge()}" name="age" placeholder="enter age:">
<input type="text" value="${u.getPassword()}"  name="password" placeholder="enter password:">
<button type="submit">Update</button>

</form>

</body>
</html>