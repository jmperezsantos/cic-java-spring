<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo usuario</title>
</head>
<body>

	<form action="/cic/user" method="post">

		<input type="text" id="name" name="name" placeholder="Nombre:" required> 
		<br>
		<input type="text" id="lastname" name="lastname" placeholder="Apellidos:" required> 
		<br>
		<input type="number" id="age" name="age" placeholder="Edad"> 
		<br> 
		
		<input type="submit" title="Registrar">

	</form>

</body>
</html>