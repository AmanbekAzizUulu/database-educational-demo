

function validateForm() {
	const userFirstName = document.getElementById("user-first-name-registration-form").value;
	const userLastName = document.getElementById("user-last-name-registration-form").value;
	const password = document.getElementById("user-password-registration-form").value;
	const confirmPassword = document.getElementById("user-confirm-password-registration-form").value;
	const userBirthdate = document.getElementById("user-birth-date-registration-form").value;

	const nameRegex = /^[A-Za-zА-Яа-яЁё]+$/;

	// Введенное имя пользователя не должно содержать меньше 2х символов
	if (userFirstName.length < 2 || userFirstName.length < 2) {
		alert("Имя и Фамилия пользователя должно содержать не менее 2 символов");
		return false;
	}

	// Проверка на наличие только букв в имени и фамилии
	if (!nameRegex.test(userFirstName) || !nameRegex.test(userLastName)) {
		alert("Имя и Фамилия могут содержать только буквы");
		return false;
	}

	// Валидация даты рождения: проверка возраста на 16 лет
	const birthDate = new Date(userBirthdate);
	const today = new Date();
	let age = today.getFullYear() - birthDate.getFullYear();
	const month = today.getMonth() - birthDate.getMonth();
	const day = today.getDate() - birthDate.getDate();

	// Если месяц или день еще не наступили в текущем году, уменьшаем возраст на 1
	if (month < 0 || (month === 0 && day < 0)) {
		age--;
	}

	if (age < 16) {
		alert("Вы должны быть не младше 16 лет для регистрации");
		return false;
	}

	// Проверка длины пароля, обязательных символов и совпадения паролей
	const passwordMinLength = 6;
	const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,}$/;

	if (password !== confirmPassword) {
		alert("Пароли не совпадают");
		return false;
	}

	if (password.length < passwordMinLength) {
		alert("Пароль должен содержать не менее 6 символов");
		return false;
	}

	if (!passwordRegex.test(password)) {
		alert("Пароль должен содержать хотя бы одну заглавную букву, одну цифру и один специальный символ");
		return false;
	}
	return true;
}
