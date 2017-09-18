<%@page import="mx.ipn.cic.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) request.getAttribute("user");
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalle de usuario</title>
</head>
<body>

	<table style="border: 1px; border-color: black;">
		<thead>
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Edad</th>
			</tr>
		</thead>

		<tbody>

			<tr>
				<td><%=user.getId()%></td>
				<td>${user.name}</td>
				<td>${user.lastname}</td>
				<td><%=user.getAge()%></td>
			</tr>

		</tbody>
	</table>
</body>
</html>