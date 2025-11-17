<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<h2>Edit Employee</h2>
    <h3> ${employee}</h3>
    <form action="update" method="post">
        <label type="text">Id:</label>
        <input  name="id" value="${employee.id}" readonly="readonly"/><br>
        <!--    type="hidden"  -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required><br>
        <label for="department">Department:</label>
        <input type="text" id="department" name="department" value="${employee.department}" required><br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
