<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <h1>Edit Employee</h1>
    <form action="updateEmployee" method="post">
        <input type="hidden" name="id" value="${employee.id}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required><br>
        <label for="department">Department:</label>
        <input type="text" id="department" name="department" value="${employee.department}" required><br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
