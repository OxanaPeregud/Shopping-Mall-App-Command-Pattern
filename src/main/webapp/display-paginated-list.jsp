<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.search"/></title>
    <link rel="stylesheet" href="search-style.css">
</head>

<body>

<form name="paginatedList" action=controller?command=paginated_list method="post">

    <div>
        <h3><fmt:message key="label.paginatedList"/></h3>
    </div>

    <table class="center">

        <tr>
            <td><fmt:message key="label.pageNumber"/>:</td>
            <td>
                <label>
                    <input type="text" name="pageNumber"/>
                </label>
            </td>
        </tr>
    </table>

    <br>

    <table class="center">
        <tr>
            <td><fmt:message key="label.pageSize"/>:</td>
            <td>
                <label>
                    <input type="text" name="pageSize"/>
                </label>
            </td>
        </tr>
    </table>

    <br>

    <div>
        <input type="submit" value="<fmt:message key="label.find"/>" name="find" class="button1"/>
        <input type="reset" value="<fmt:message key="label.reset"/>" name="reset" class="button2"/>
    </div>

    <p>
        <a href="javascript:history.back()"><fmt:message key="label.goBack"/></a>
    </p>

</form>

</body>
</html>
