<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/search-style.css">
</head>
<body>

<form action=front-controller?command=LOGIN method="post">

    Name:
    <label>
        <input type="text" name="name" required>
    </label>
    <br>

    Password:
    <label>
        <input type="password" name="password" required>
    </label>
    <br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
