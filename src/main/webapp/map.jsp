<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <meta charset="utf-8"/>
    <title><fmt:message key="label.mall"/></title>
    <meta content="Mall Map"/>
    <meta content="Lowerevel.png"/>
    <meta content="summary_large_image"/>
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <link href="https://assets.website-files.com/5fd037f32f38988415755fe4/css/burnsville-mall.d2fd1ad96.css"
          rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js"
            type="text/javascript"></script>
    <script type="text/javascript">WebFont.load({
        google:
            {
                families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic," +
                "500,500italic,600,600italic,700,700italic,800,800italic,900,900italic",
                    "Lato:100,100italic,300,300italic,400,400italic,700,700italic,900,900italic",
                    "Varela Round:400", "Great Vibes:400", "Oswald:200,300,400,500,600,700", "Bitter:400,700,400italic",
                    "Slabo 27px:regular", "Source Sans Pro:200,200italic,300,regular",
                    "Open Sans Condensed:300,300italic,700", "Roboto Slab:100,300,regular,700",
                    "Arimo:regular,italic,700,700italic", "Catamaran:100,200,300,regular,500,600,700,800,900"]
            }
    });</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"
            type="text/javascript"></script>
    <script type="text/javascript">!function (o, c) {
        var n = c.documentElement, t = " w-mod-";
        n.className += t + "js",
        ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch")
    }(window, document);
    </script>
    <link href="favicon.png" rel="shortcut icon" type="image/x-icon"/>
    <link href="webclip.png" rel="apple-touch-icon"/>
    <script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-185487169-1">
    </script>
    <script type="text/javascript">window.dataLayer = window.dataLayer || [];

    function gtag() {
        dataLayer.push(arguments);
    }

    gtag('js', new Date());
    gtag('config', 'UA-185487169-1', {'anonymize_ip': false});</script>
    <script src="https://www.google.com/recaptcha/api.js" type="text/javascript"></script>
    <script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script');

        ga('create', 'UA-78250365-1', 'auto');
        ga('send', 'pageview');

    </script>
</head>
<body>
<div data-collapse="small" data-animation="default" data-duration="400"
     role="banner" class="navbar w-nav">
    <div class="nav_div"><a href="${pageContext.request.contextPath}/display-all-shops"
                            data-ix="fade-down-on-load" class="brand-2 w-nav-brand">
        <img src="logo.png" alt="Shopping Mall logo" class="brand-logo"/></a>
        <nav role="navigation"

             class="nav-menu w-nav-menu"><a href="${pageContext.request.contextPath}/display-all-shops"
                                            class="nav-link w-nav-link"><fmt:message key="label.shops"/></a>

            <a href="${pageContext.request.contextPath}/contact" class="nav-link w-nav-link">
                <fmt:message key="label.contact"/></a></nav>

        <div class="menu-button w-nav-button">
            <div class="menu-text">MENU</div>
            <div class="hamburger w-icon-nav-menu"></div>
        </div>
    </div>
</div>
<h1 class="page-heading"><fmt:message key="label.map"/></h1>
<div class="map_flexbox"><a href="#" class="map_lightbox w-inline-block w-lightbox">
    <img src="lower-level.png"
         alt="Map of the store locations in the mall" class="map_image"/>
    <script type="application/json" class="w-json">{
        "items": [
            {
                "type": "image",
                "_id": "lower-level.png",
                "fileName": "lower-level.png",
                "origFileName": "lower-level.png",
                "width": 1000,
                "height": 637,
                "fileSize": 35420,
                "url": "lower-level.png"
            }
        ],
        "group": "map"
    }</script>
</a><a href="#" class="map_lightbox w-inline-block w-lightbox"><img
        src="upper-level.png"
        alt="Map of the store locations in the mall"
        sizes="(max-width: 479px) 100vw, (max-width: 767px) 50vw, (max-width: 3030px) 33vw, 1000px"
        srcset="upper-level-p-500.png 500w, upper-level.png 1000w"
        class="map_image"/>
    <script type="application/json" class="w-json">{
        "items": [
            {
                "width": 1000,
                "caption": "Upper Level",
                "height": 637,
                "fileName": "upper-level.png",
                "origFileName": "upper-level.png",
                "url": "upper-level.png",
                "_id": "UpperLevel",
                "type": "image",
                "fileSize": 146182
            }
        ],
        "group": "map"
    }</script>
</a><a href="#" class="map_lightbox w-inline-block w-lightbox"><img
        src="food-court.png"
        alt="Map of the store locations in the mall" class="map_image"/>
    <script type="application/json" class="w-json">{
        "items": [
            {
                "type": "image",
                "_id": "FoodCourt",
                "fileName": "food-court.png",
                "origFileName": "food-court.png",
                "width": 588,
                "height": 492,
                "fileSize": 11595,
                "url": "food-court.png"
            }
        ],
        "group": "map"
    }</script>
</a></div>

<script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=5fd037f32f38988415755fe4"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
<script src="https://assets.website-files.com/5fd037f32f38988415755fe4/js/burnsville-mall.b474a1e20.js"
        type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script>
</body>
</html>
