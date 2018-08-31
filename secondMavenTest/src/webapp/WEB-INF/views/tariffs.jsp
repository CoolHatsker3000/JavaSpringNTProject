<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Tariffs</title>
    <s:url value="/resources/css/bootstrap.min.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />

</head>
<body>
    <a href="/user" class="btn btn-info">Go back to user page</a>
    <div class="container">
    <c:if test="${cookie.currentUserId.value==123456789}">
        <b>add new tariff:</b>
        <form action="tariffs/new" method="post" class="form-inline">
            <div class="form-group">
                <label for="tariffNameInput">New tariff name:</label>
                <input name="tariffName" type="text" class="form-control" id="tariffNameInput"/>
                <input type="submit" value="add new tariff" class="btn btn-success">
            </div>
        </form>
    </c:if>
    <ul class="list-group">
        <c:forEach var="tariffInfo" items="${tariffsInfo}">
            <c:if test="${tariffInfo.value.size()!=0 or cookie.currentUserId.value==123456789 or tariffInfo.value=='?'}">
            <li class="list-group-item"><h2>${tariffInfo.key.tariffName}</h2>
                <c:forEach var="attribute" items="${tariffInfo.value}">
                    <b>${attribute.key}: ${attribute.value}</b><br>
                </c:forEach>
                <c:choose>
                    <c:when test="${tariffId==tariffInfo.key.tariffId}">
                    <h3>Chosen</h3>
                    </c:when>
                    <c:when test="${cookie.currentUserId.value==123456789}">
                        <a href="/tariffs/edit/${tariffInfo.key.tariffId}" class="btn btn-warning">Edit tariffs attributes</a>
                        <form action="/tariffs" method="post">
                            <input type="hidden" name="tariffIdToDelete" value="${tariffInfo.key.tariffId}"/>
                            <input type="submit" value="delete tariff" class="btn btn-danger"/>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <sf:form action="/user" method="post" modelAttribute="userTariff">
                            <sf:hidden path="tariffID" value="${tariffInfo.key.tariffId}"/>
                            <input type="submit" value="Choose this tariff" class="btn btn-dark">
                        </sf:form>
                    </c:otherwise>
                </c:choose>
            </li>
            </c:if>
        </c:forEach>
    </ul>
    </div>
</body>
</html>
