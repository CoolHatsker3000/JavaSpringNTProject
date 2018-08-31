<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 28.08.2018
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Registration page</title>
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
    <b>${message}</b>
            <sf:form method="post" modelAttribute="user">
                <div class="form-group">

                    <div class="col-10">
                        <label for="userIdInput">Enter your Phone Number:</label>
                        <sf:input path="userId" id="userIdInput" cssClass="form-control"/>
                        <sf:errors path="userId" cssClass="error"/><br>
                    </div>

                    <div class="col-10">
                        <label for="passwordInput">Enter password:</label>
                        <sf:password path="userPassword" id="passwordInput" cssClass="form-control"/><br>
                        <sf:errors path="userPassword" cssClass="error"/><br>
                    </div>
                    <input class="btn btn-default" type="submit" value="Register"/>
                </div>
            </sf:form>
        <a href="/" class="btn btn-info">Back to log in page</a>
    </div>
    </body>
</html>
