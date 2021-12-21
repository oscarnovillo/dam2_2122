<%--
  Created by IntelliJ IDEA.
  User: oscar
  Date: 21/12/2021
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/ServletCambioContraseña" method="POST">


    <input type="text" name="pass" />


    <input type="hidden" name="codido" value="${codigo}" />
    <c:if  test="${codigo != null}">
            HOLA MUNDO
    </c:if>



</form>



</body>
</html>
