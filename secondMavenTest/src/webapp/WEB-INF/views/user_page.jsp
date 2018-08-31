<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 22.08.2018
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <title>User Page</title>
        <s:url value="/resources/css/bootstrap.min.css" var="springCss" />
        <link href="${springCss}" rel="stylesheet" />

</head>
<body>
    <div class="container">
        <c:if test="${empty tariff.tariffName}" >
            <h1>
                Hello, User! your have no tariff on use, choose one!
            </h1>
        </c:if>
        <c:if test="${not empty tariff.tariffName}">
            <h1>Hello, User, your tariff is ${tariff.tariffName}</h1>
            <ul class="list-group">
                <c:forEach var="attr" items="${attrs}">
                    <li class="list-group-item"><b>${attr.key}</b>: ${attr.value}</li>
                </c:forEach>
            </ul>
        </c:if>
            <c:if test="${empty tariff.tariffName}">
                <a href="/tariffs" class="btn btn-primary">Go to tariffs list</a>
            </c:if>
            <c:if test="${not empty tariff.tariffName}">
                <a href="/tariffs" class="btn btn-primary">Change tariff</a>
            </c:if>

    <a href="/logout" class="btn btn-dark">Log out</a>
    </div>

</body>
</html>
