<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar usuario</title>
</head>
<body>

	<form action="/cic/user/${user.id}" method="post">

		<input type="text" id="name" name="name" value="${user.name}" required>
		<br>
		<input type="text" id="lastname" name="lastname" value="${user.lastname}" required>
		<br>
		<input type="text" id="age" name="age" value="${user.age}">
		<br>
		<input type="submit">

	</form>

</body>
</html>