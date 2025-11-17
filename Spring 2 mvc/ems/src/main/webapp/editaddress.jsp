<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Address</title>
</head>
<body>
    <h2>Edit Address</h2>
    <form action="updateAddress" method="post">
        <input type="hidden" name="id" value="${address.id}">
        <label for="street">Street:</label>
        <input type="text" id="street" name="street" value="${address.street}" required><br>
        <label for="city">City:</label>
        <input type="text" id="city" name="city" value="${address.city}" required><br>
        <label for="state">State:</label>
        <input type="text" id="state" name="state" value="${address.state}" required><br>
        <label for="zip">ZIP Code:</label>
        <input type="text" id="zip" name="zip" value="${address.zip}" required><br>
        <button type="submit">Update Address</button>
    </form>
</body>
</html>
