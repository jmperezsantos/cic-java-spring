<%@page import="mx.ipn.cic.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<User> users = (List<User>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todos los usuarios</title>
</head>
<body>

	<a href="/cic/user/newForm">Nuevo Usuario</a>

	<br>

	<table style="border: 1px; border-color: black; border-style: solid;">
		<thead>
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Apellido</th>
			</tr>
		</thead>

		<tbody>

			<%
				for (User user : users) {
			%>
			<tr>
				<td><a href="/cic/user/<%=user.getId()%>"><%=user.getId()%></a></td>
				<td><%=user.getName()%></td>
				<td><%=user.getLastname()%></td>

				<td><a href="/cic/user/<%=user.getId()%>/updateForm">Modificar</a></td>
				<td><a href="/cic/user/delete/<%=user.getId()%>">Eliminar</a></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>

</body>
</html>