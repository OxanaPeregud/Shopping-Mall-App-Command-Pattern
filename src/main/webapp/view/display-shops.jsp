<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.mall"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/table.css">
</head>

<body>

<button type="button" class="button"><a class="homepage" href="map"><fmt:message key="label.back"/></a></button>

<%@include file="dropdown-client.jsp" %>

<div>
    <h1><fmt:message key="label.app"/></h1>
</div>

<div>
    <form action="display-all-shops" method="post">
        <table id="customers">
            <caption><h2><fmt:message key="label.shops"/></h2></caption>
            <tr>
                <th><fmt:message key="label.shopName"/></th>
                <th><fmt:message key="label.shopDescription"/></th>
                <th><fmt:message key="label.location"/></th>
                <th><fmt:message key="label.info"/></th>
                <th><fmt:message key="label.info"/></th>
            </tr>

            <c:forEach var="shop" items="${listShops}">
                <tr>
                    <c:if test="${shop != null}">
                        <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
                    </c:if>
                    <td><c:out value="${shop.name}"/></td>
                    <td><c:out value="${shop.description}"/></td>
                    <td><c:out value="${shop.location}"/></td>
                    <td>
                        <a href="info-shop?id=<c:out value='${shop.id}' />"><fmt:message key="label.fullShopInfo"/></a>
                    </td>
                    <td>
                        <a href="shop-discounts?id=<c:out value='${shop.id}' />"><fmt:message
                                key="label.shopDiscounts"/></a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </form>

</div>

<footer>
    <a href="admin-login"><fmt:message key="label.dbAccess"/></a>
</footer>

</body>
</html>
