<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.contactForm"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/contact.css">
</head>

<body>

<div class="container">
    <h3><fmt:message key="label.contactForm"/></h3>
    <form action="mailto:ox.peregud@gmail.com" method="POST" enctype="multipart/form-data" name="EmailForm">

        <label><fmt:message key="label.firstName"/></label>
        <label>
            <input name="first_name" type="text" required placeholder=<fmt:message key="label.exampleFirstName"/>>
        </label>
        <br>
        <label><fmt:message key="label.lastName"/></label>
        <label>
            <input name="last_name" type="text" required placeholder=<fmt:message key="label.exampleLastName"/>>
        </label>
        <br>
        <label><fmt:message key="label.email"/></label>
        <label>
            <input name="email" type="email" required placeholder="you@domain.com"/>
        </label>
        <br>
        <label><fmt:message key="label.message"/></label><br>
        <label>
            <textarea name="message" cols="30" rows="10">
            </textarea>
        </label>
        <div class="center">
            <input type="submit" value=<fmt:message key="label.send"/>>
        </div>
    </form>

    <a href="javascript:history.back()"><fmt:message key="label.back"/></a>

</div>
</body>
</html>
