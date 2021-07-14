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
    <script src="view/validation-discount.js"></script>
</head>

<body>

<button type="button" class="button"><a class="homepage" href="list-shops"><fmt:message key="label.allShops"/></a>
</button>

<div>
    <c:if test="${shop != null}">
    <form name="discountForm" onsubmit="return validateForm()"
          action="${pageContext.request.contextPath}/insert-discount-to-shop" method="post">
        </c:if>

            <caption>
                <h2><fmt:message key="label.infoShop"/></h2>
            </caption>

            <c:if test="${shop != null}">
                <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
            </c:if>

            <div class="row">
                <label><fmt:message key="label.discount"/></label>
                <label>
                    <input type="text" name="discount" maxlength="2"
                           value="<c:out value='${discount.discount}' />"
                    />
                </label>
                <div class="error" id="discountErr"></div>
            </div>

            <div class="row">
                <label><fmt:message key="label.discountStartDate"/></label>
                <label>
                    <input type="date" name="discountStartDate" required pattern="\d{4}-\d{2}-\d{2}"
                           value="<c:out value='${discount.discountStartDate}' />"
                    />
                    <span class="validity"></span>
                </label>
            </div>

            <div class="row">
                <label><fmt:message key="label.discountEndDate"/></label>
                <label>
                    <input type="date" name="discountEndDate" required pattern="\d{4}-\d{2}-\d{2}"
                           value="<c:out value='${discount.discountEndDate}' />"
                    />
                    <span class="validity"></span>
                </label>
            </div>

            <div class="row">
                <label><fmt:message key="label.shop"/></label>
                <label>
                    <input type="text" name="shopId"
                           value="<c:out value='${shop.id}' />"
                    />
                </label>
                <div class="error" id="shopErr"></div>
            </div>


            <div class="row">
                <input type="submit" value="<fmt:message key="label.submit"/>">
            </div>

        </form>

</div>
</body>
</html>
