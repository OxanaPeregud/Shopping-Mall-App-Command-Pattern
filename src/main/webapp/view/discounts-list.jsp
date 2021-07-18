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

<%@include file="logout.jsp" %>
<%@include file="dropdown-admin.jsp" %>

<div>
    <h1><fmt:message key="label.app"/></h1>
</div>

<div>
    <form action=controller?command=delete_list_discounts method="post">
        <table id="customers">
            <caption><h2><fmt:message key="label.allDiscounts"/></h2></caption>
            <tr>
                <th>ID</th>
                <th><fmt:message key="label.discount"/></th>
                <th><fmt:message key="label.discountStartDate"/></th>
                <th><fmt:message key="label.discountEndDate"/></th>
                <th><fmt:message key="label.shop"/></th>
                <th><fmt:message key="label.info"/></th>
                <th><fmt:message key="label.info"/></th>
            </tr>

            <c:forEach var="discount" items="${listDiscounts}">
                <tr>
                    <td><c:out value="${discount.id}"/></td>
                    <td><c:out value="${discount.discount}"/></td>
                    <td><c:out value="${discount.discountStartDate}"/></td>
                    <td><c:out value="${discount.discountEndDate}"/></td>
                    <td><c:out value="${discount.shop}"/></td>
                    <td>
                        <a href=controller?command=edit_discount&id=<c:out value='${discount.id}'/>>
                            <fmt:message key="label.edit"/></a>
                    </td>
                    <td>
                        <label><input type="checkbox" name="deleteDiscount"
                                      value="${discount.id}"><fmt:message key="label.delete"/></label>
                    </td>
                </tr>
            </c:forEach>

            <tr class="right">
                <td>
                    <input type="submit" value="<fmt:message key="label.delete"/>"/>
                </td>
            </tr>

        </table>
    </form>

</div>
</body>
</html>
