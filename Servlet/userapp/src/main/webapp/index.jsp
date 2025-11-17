<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Index page</h1>
<h2><a href="login.jsp">Click here  to login</a></h2>
<h2><a href="reg.jsp">Click here to register</a></h2>
<a href="hi">Click here to say hii</a> <!-- only get request anchor tag -->

<form action="hi" method="post">
<button type="submit">Submit</button>

</form>
<br>
<br>
<br>
<form action="log" >
 <label for="username">email:</label>
        <input type="text" id="username" name="email"  placeholder="enter email:"  required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"   placeholder="enter password:" required><br><br>

        <input type="submit" value="Login">
</form>

</body>
</html>