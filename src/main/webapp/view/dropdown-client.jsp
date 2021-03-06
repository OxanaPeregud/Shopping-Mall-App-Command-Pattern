<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.mall"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dropdown-menu.css">
</head>

<body>

<label class="dropdown">
    <div class="dd-button">
        <fmt:message key="label.menu"/>
    </div>

    <input type="checkbox" class="dd-input" id="test">

    <ul class="dd-menu">
        <li>
            <a href=controller?command=display_shops><fmt:message key="label.shops"/></a>
        </li>
        <li>
            <a href=controller?command=display_discounts><fmt:message key="label.discounts"/></a>
        </li>
        <li>
            <a href="search-discount-shop.jsp"><fmt:message key="label.searchDiscount"/></a>
        </li>
        <li>
            <a href="search-shop.jsp"><fmt:message key="label.search"/></a>
        </li>
        <li>
            <a href=controller?command=shop_actual_discounts><fmt:message key="label.searchActualDiscount"/></a>
        </li>
        <li>
            <a href="display-paginated-list.jsp"><fmt:message key="label.paginatedList"/></a>
        </li>
    </ul>
</label>

</body>
</html>
