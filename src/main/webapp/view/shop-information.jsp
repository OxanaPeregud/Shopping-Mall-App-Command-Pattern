<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.fullShopInfo"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/info.css">
</head>

<body>

<div>
    <c:if test="${shop != null}">
        <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
    </c:if>
</div>

<table>
    <tr>
        <td>
            <div id="bloc1">

                <div class="row">
                    <h4><fmt:message key="label.shopName"/></h4>
                    <label>
                        <c:out value='${shop.name}'/>
                    </label>
                </div>


                <div class="row">
                    <h4><fmt:message key="label.shopDescription"/></h4>
                    <label>
                        <c:out value='${shop.description}'/>
                    </label>
                </div>
        </td>

        <td>
            <div id="bloc2">
                <div class="row">
                    <h4><fmt:message key="label.location"/></h4>
                    <label>
                        <c:out value='${shop.location}'/>
                    </label>
                </div>

                <div class="row">
                    <h4><fmt:message key="label.email"/></h4>
                    <label>
                        <c:out value='${shop.email}'/>
                    </label>
                </div>

                <div class="row">
                    <h4><fmt:message key="label.mobile"/></h4>
                    <label>
                        <c:out value='${shop.mobile}'/>
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
