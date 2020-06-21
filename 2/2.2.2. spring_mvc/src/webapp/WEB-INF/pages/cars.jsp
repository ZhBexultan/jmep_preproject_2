<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="locale.title"/></title>
</head>
<body>
    <ul>
        <li><a href="?lang=en"><fmt:message key="locale.lang.en"/></a></li>
        <li><a href="?lang=ru"><fmt:message key="locale.lang.ru"/></a></li>
    </ul>
    <h2><fmt:message key="locale.title"/></h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th><fmt:message key="locale.table.name"/></th>
                <th><fmt:message key="locale.table.series"/></th>
                <th><fmt:message key="locale.table.year"/></th>
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
    <a href="/hello"><fmt:message key="locale.back"/></a>
</body>
</html>
