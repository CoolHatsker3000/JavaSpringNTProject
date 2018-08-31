<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

    <head>
        <title>Login page</title>
        <style>
            .error {
                color: red;
                font-weight: bold;
            }
        </style>
        <s:url value="/resources/css/bootstrap.min.css" var="springCss" />
        <link href="${springCss}" rel="stylesheet" />

    </head>
    <body>
    <div class="container">
    <sf:form method="post" modelAttribute="user" action="/user">
        <div class="form-group">

                <label for="userIdInput">Enter your Phone Number:</label>
                <div class="col-10">
                <sf:input path="userId" id="userIdInput" cssClass="form-control"/>
                <sf:errors path="userId" cssClass="error"/><br>
                </div>
                <label for="passwordInput">Enter password:</label>
                <div class="col-10">
                <sf:password path="userPassword" id="passwordInput" cssClass="form-control"/><br>
                <sf:errors path="userPassword" cssClass="error"/><br>
                </div>
                <input class="btn btn-default" type="submit" value="Log in"/>
        </div>
    </sf:form>
    <a href="/register" class="btn btn-info">Register</a>
    </div>
    </body>

</html>