<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap/css/bootstrap.min.css">
    <title>User registration</title>

</head>
<body>
    <h2 class="text-center text-primary mt-4" >Форма регистрации</h2>
	<div class="container mt-5 mb-5 ml-5 mr-5"">
    	<form action="${pageContext.request.contextPath}/registration" method="post" onsubmit="return validateForm()">
			<!-- First Name -->
			<div class="form-group">
				<label for="user-first-name-registration-form" class="form-label">Имя пользователя:</label>
    	    	<input type="text" id="user-first-name-registration-form" name="userFirstName" class="form-control" required><br>
			</div>

			<!-- Last Name -->
			<div class="form-group">
				<label for="user-last-name-registration-form" class="form-label">Фамилия пользователя:</label>
    	    	<input type="text" id="user-last-name-registration-form" name="userLastName" class="form-control" required><br>
			</div>

			<!-- Логин пользователя -->
			<div class="form-group">
				<label for="user-login-registration-form" class="form-label">Логин пользователя:</label>
    	    	<input type="text" id="user-login-registration-form" name="userLogin" class="form-control" required><br>
			</div>

			<!-- Роль пользователя -->
			<div class="form-group">
			    <select id="role" name="userRole" class="form-select" required>
					<c:forEach items="${requestScope.userRoles}" var="role">
    			 		<option value="${role}">${role}</option><br>
					</c:forEach>
    	    	</select><br>
			</div>

			<!-- Email -->
			<div class="form-group">
    	    	<label for="email" class="form-label">Email:</label>
    	    	<input type="email" id="user-email-registration-form" name="userEmail" class="form-control" required><br>
			</div>

			<!-- Дата рождения -->
			<div class="form-group">
				<label for="user-birth-date-registration-form" class="form-label">Дата рождения:</label>
				<input type="date" id="user-birth-date-registration-form" name="userBirthDate" class="form-control" required><br>
			</div>

			<!-- Пол (gender) -->
			<div class="form-group mb-2 mt-2">
			    <label class="form-label">Пол:</label><br>
			    <c:forEach items="${requestScope.userGenders}" var="gender">
			        <div class="form-check form-check-inline">
			            <input class="form-check-input" type="radio" id="user-gender-${gender.toLowerCase()}" name="userGender" value="${gender.toLowerCase()}">
			            <label class="form-check-label" for="user-gender-${gender.toLowerCase()}">${gender}</label>
			        </div>
			    </c:forEach>
			</div>

			<!-- Пароль -->
			<div class="form-group">
    	    	<label for="password">Пароль:</label>
    	    	<input type="password" id="user-password-registration-form" name="userPassword" class="form-control" required><br>
			</div>

			<!-- Подтверждение пароля -->
			<div class="form-group">
    	    	<label for="user-confirm-password-registration-form" class="form-label">Подтвердите пароль:</label>
    	    	<input type="password" id="user-confirm-password-registration-form" name="userConfirmPassword" class="form-control" required><br>
			</div>

			<!-- Отправка формы -->
			<div class="form-group">
    	    	<input type="submit" value="Зарегистрироваться" class="btn btn-primary">
			</div>
    	</form>

		<c:if test="${not empty requestScope.errors}">
			<div style="color: red">
				<c:forEach items="${requestScope.errors}" var="item">
					<span>${error.message}</span>
					<br>
				</c:forEach>
			</div>
		</c:if>
	</div>

	<script src="${pageContext.request.contextPath}/assets/scripts/validation/registration-validation.js"></script>
	<script src="${pageContext.request.contextPath}/assets/scripts/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
