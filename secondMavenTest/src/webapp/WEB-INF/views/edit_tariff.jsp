<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 26.08.2018
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tariff Editor</title>
    <s:url value="/resources/css/bootstrap.min.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />
</head>
<body>
    <a href="/tariffs" class="btn btn-info">Back to tariffs list</a>
    <div class="container">
    <h1>${tariff.tariffName}</h1>
    <form method="post">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Value</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="attr" items="${attrs}">
                    <tr>
                        <th>${attr.key.attrName}: </th>
                        <th>
                            <input name="${attr.key.attrId}" type="text" value="${attr.value.attrV}" class="form-control form-control-sm"/>
                        </th>
                        <th>
                            <a href="/tariffs/edit/${tariff.tariffId}/del/${attr.value.attrId}" class="btn btn-danger">
                                Delete Attribute
                            </a>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="update" class="btn btn-info"/>
    </form>
    <h2>Add attributes</h2><br>
    <sf:form action="/tariffs/edit/${tariff.tariffId}/add" method="post">
        <c:forEach var="attr" items="${otherAttrs}">
            <input type="checkbox" name="attrsToAdd" value="${attr.attrId}"/><c:out value="${attr.attrName}"/><br>
        </c:forEach>
        <br><br>
        <input type="submit" value="Add Attributes" class="btn btn-info">
    </sf:form>
    <h2>Create New Attribute</h2>
    <form action="/tariffs/edit/${tariff.tariffId}/new" method="post" class="form-inline">
        <div class="col-10">
            <input type="text" name="attrName" placeholder="enter name of new attribute" class="form-control"/>
            <input type="submit" value="Create" class="btn btn-success"/>
        </div>
    </form>
    </div>
</body>
</html>
