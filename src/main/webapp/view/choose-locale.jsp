<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title>Locale</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/locale.css">
</head>

<body>
<h1>
    <fmt:message key="label.chooseSessionLocale"/>
</h1>

<div class="container">
    <button type="button" class="button" style="vertical-align:middle"><a href="?sessionLocale=en"><fmt:message
            key="label.lang.en"/></a>
    </button>
    <button type="button" class="button" style="vertical-align:middle"><a href="?sessionLocale=ru"><fmt:message
            key="label.lang.ru"/></a>
    </button>
</div>

<br>
<br>

<h2>
    <c:if test="${not empty param.sessionLocale}">
        <fmt:message key="label.sessionChangeSuccess"/>
        <button type="button" class="button1"><a href="${pageContext.request.contextPath}/map">
            <fmt:message key="label.startApp"/></a></button>
    </c:if>
</h2>

</body>
</html>
