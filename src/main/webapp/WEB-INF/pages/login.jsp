<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <title>Sign In</title>
</head>
<body>
    <h2>Login</h2>
    <form action="${pageContext.request.contextPath}/index/login" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
		<br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
		<br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
		<br>

		<button type="submit">Sign In</button>

		<c:if test="${param.error != null}">
			<div style="color: red;">
				<span>Email or password is not correct</span>
			</div>
		</c:if>
    </form>
	<br>
	<br>
	<br>

	<a href="${pageContext.request.contextPath}/registration">
       	<button type="submit">Sign Up</button>
	</a>
</body>
</html>
