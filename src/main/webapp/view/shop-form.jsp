<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.shopForm"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/form.css">
    <script src="view/validation-shop.js"></script>
</head>

<body>

<button type="button" class="button"><a class="homepage" href="list-shops"><fmt:message key="label.allShops"/></a>
</button>

<div>
    <c:if test="${shop != null}">
    <form name="shopForm" onsubmit="return validateForm()"
          action="${pageContext.request.contextPath}/update-shop" method="post">
        </c:if>

        <c:if test="${shop == null}">
        <form name="shopForm" onsubmit="return validateForm()"
              action="${pageContext.request.contextPath}/insert-shop" method="post">
            </c:if>

            <caption>
                <h2><fmt:message key="label.infoShop"/></h2>
            </caption>

            <c:if test="${shop != null}">
                <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
            </c:if>

            <div class="row">
                <label><fmt:message key="label.shopName"/></label>
                <label>
                    <input type="text" name="name" maxlength="255"
                           value="<c:out value='${shop.name}' />"
                    />
                </label>
                <div class="error" id="nameErr"></div>
            </div>

            <div class="row">
                <label><fmt:message key="label.shopDescription"/></label>
                <label>
                    <input type="text" name="description" maxlength="255"
                           value="<c:out value='${shop.description}' />"
                    />
                </label>
                <div class="error" id="descriptionErr"></div>
            </div>

            <div class="row">
                <label><fmt:message key="label.location"/></label>
                <label>
                    <input type="text" name="location" maxlength="255"
                           value="<c:out value='${shop.location}' />"
                    />
                </label>
                <div class="error" id="locationErr"></div>
            </div>

            <div class="row">
                <label><fmt:message key="label.email"/></label>
                <label>
                    <input type="text" name="email"
                           value="<c:out value='${shop.email}' />"
                    />
                </label>
                <div class="error" id="emailErr"></div>
            </div>

            <div class="row">
                <label><fmt:message key="label.mobile"/></label>
                <label>
                    <input type="text" name="mobile" maxlength="12"
                           value="<c:out value='${shop.mobile}' />"
                    />
                </label>
                <div class="error" id="mobileErr"></div>
            </div>

            <div class="row">
                <input type="submit" value="<fmt:message key="label.submit"/>">
            </div>

        </form>

</div>
</body>
</html>
