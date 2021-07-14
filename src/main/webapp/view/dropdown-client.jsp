<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.mall"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dropdown.css">
</head>

<body>

<label class="dropdown">
    <div class="dd-button">
        <fmt:message key="label.menu"/>
    </div>

    <input type="checkbox" class="dd-input" id="test">

    <ul class="dd-menu">
        <li>
            <a href="display-all-shops"><fmt:message key="label.shops"/></a>
        </li>
        <li>
            <a href="display-all-discounts"><fmt:message key="label.discounts"/></a>
        </li>
        <li>
            <a href="view/search-discount-shop.jsp"><fmt:message key="label.searchDiscount"/></a>
        </li>
        <li>
            <a href="view/search-shop.jsp"><fmt:message key="label.search"/></a>
        </li>
        <li>
            <a href="shops-actual-discounts"><fmt:message key="label.searchActualDiscount"/></a>
        </li>
    </ul>
</label>

</body>
</html>
