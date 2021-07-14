<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title>Login Operations</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/admin-login">Login</a> |
<a href="${pageContext.request.contextPath}/logout">Logout</a> |
<hr>

</body>
</html>
