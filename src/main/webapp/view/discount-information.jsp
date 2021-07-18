<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.fullDiscountInfo"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/info.css">
</head>

<body>

<div>
    <c:if test="${discount != null}">
        <input type="hidden" name="id" value="<c:out value='${discount.id}' />"/>
    </c:if>
</div>

<table>
    <tr>
        <td>
            <div id="bloc1">

                <div class="row">
                    <h4><fmt:message key="label.discount"/></h4>
                    <label>
                        <c:out value='${discount.discount}'/>
                    </label>
                </div>

                <div class="row">
                    <h4><fmt:message key="label.discountStartDate"/></h4>
                    <label>
                        <c:out value='${discount.discountStartDate}'/>
                    </label>
                </div>
        </td>

        <td>
            <div id="bloc2">
                <div class="row">
                    <h4><fmt:message key="label.discountEndDate"/></h4>
                    <label>
                        <c:out value='${discount.discountEndDate}'/>
                    </label>
                </div>

            </div>
        </td>
    </tr>
</table>

<div class="link">
    <a href="javascript:history.back()"><fmt:message key="label.goBack"/></a>
</div>

</body>
</html>
