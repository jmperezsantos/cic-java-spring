<%@page import="mx.ipn.cic.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<br> Con Java
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

	<br> Con JSTL
	<table style="border: 1px; border-color: black; border-style: solid;">
		<thead>
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Apellido</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${users}" var="u">
				<tr>
					<td><a href="/cic/user/${u.id}">${u.id}</a></td>
					<td>${u.name}</td>
					<td>${u.lastname}</td>

					<td><a href="/cic/user/${u.id}/updateForm">Modificar</a></td>
					<td><a href="/cic/user/delete/${u.id}">Eliminar</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<br>

	<ul>
		<c:forEach begin="0" end="10" var="i">

			<c:if test="${i % 2 == 0}">
				<li>${i}espar</li>
			</c:if>

			<c:if test="${i % 2 != 0}">
				<li>${i}noes par</li>
			</c:if>

			<c:if test="${i % 3 == 0}">
				<li>${i}esdivisible entre 3</li>
			</c:if>

		</c:forEach>
	</ul>

	<ul>
		<c:forEach begin="0" end="10" var="i">

			<c:choose>

				<c:when test="${i % 2 == 0}">
					<li>${i}espar</li>
				</c:when>

				<c:when test="${i % 3 == 0}">
					<li>${i}esdivisible entre 3</li>
				</c:when>

				<c:otherwise>
					<li>${i}noes par</li>
				</c:otherwise>

			</c:choose>

		</c:forEach>
	</ul>

</body>
</html>