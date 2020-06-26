<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h2>Add User</h2>
    <form action="/user" method="post">
        Username: <input type="email" name="username" placeholder="Username" required> <br>
        First Name: <input type="text" name="firstName" placeholder="First Name" required> <br>
        Last Name: <input type="text" name="lastName" placeholder="Last Name" required> <br>
        <input type="submit" value="Add User">   
    </form><hr>
    
    <h2>Users</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Fullname</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <c:if test="${users != null}">
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.username}" /></td>
                        <td><c:out value="${user.firstName}" />     <c:out value="${user.lastName}" /></td>
                        <td><a href="/user/${user.id}">Edit</a></td>
                        <td>
                            <form action="/deleteUser" method="post">
                                <input type="hidden" name="id" value="${user.id}">
                                <input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </c:if>
    </table>
</body>
</html>
