<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h2>User Page</h2>
<form action="/updateUser" method="post">
    <input type="hidden" name="id" value="${user.id}">
    Username: <input type="email" name="username" value="${user.username}" required> <br>
    First Name: <input type="text" name="firstName" value="${user.firstName}" required> <br>
    Last Name: <input type="text" name="lastName" value="${user.lastName}" required> <br>
    <input type="submit" value="Update">
</form>
<a href="/users">Back</a>
</body>