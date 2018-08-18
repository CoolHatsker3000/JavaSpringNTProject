<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <style>
        .error {
            color: red;
            font-weight: bold;
        }
    </style>
    <body>

        <div>
            <sf:form method="post" modelAttribute="user">
                <sf:input path="userId"/>
                <sf:errors path="userId" cssClass="error"/>
                <sf:input path="userBalance"/>
                <sf:errors path="userBalance" cssClass="error"/>
                <input type="submit" value="Submit"/>
            </sf:form>
        </div>
    </body>

</html>