<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
    <h2>Cars</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Series</th>
                <th>Year</th>
            </tr>
        </thead>
        <c:if test="${cars != null}">
            <tbody>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td><c:out value="${car.id}" /></td>
                        <td><c:out value="${car.name}" /></td>
                        <td><c:out value="${car.series}" /></td>
                        <td><c:out value="${car.year}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </c:if>
    </table>
    <br>
    <a href="/hello">Back</a>
</body>
</html>
