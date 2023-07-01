<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<link href="view/styles.css" rel="stylesheet">
<title>Listar Usuarios</title>
</head>
<body class="container">
<header>
	<jsp:include page="Menu.jsp"></jsp:include>
</header>
<h1>Usuarios Registrados</h1>
<div class="table-responsive">
	<table class="table table-striped">
		<thead class="table-dark">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Tipo</th>
			</tr>
		</thead>
		<tbody>
			<f:forEach var="u" items="${user}">
				<tr>
					<td><f:out value="${u.getId()}"></f:out></td>
					<td><f:out value="${u.getNombre()}"></f:out></td>
					<td><f:out value="${u.getTipo()}"></f:out></td>
					<td><f:if test="${u.getTipo().name().equals('CLIENTE')}">
					<a href="${pageContext.request.servletContext.contextPath}/EditarClienteServlet?id=${u.getId()}"><button class="btn btn-primary">Edit</button></a></f:if>
					<f:if test="${u.getTipo().name().equals('ADMINISTRATIVO')}">
					<a href="${pageContext.request.servletContext.contextPath}/EditarAdministrativoServlet?id=${u.getId()}"><button class="btn btn-primary">Edit</button></a></f:if>
					<f:if test="${u.getTipo().name().equals('PROFESIONAL')}">
					<a href="${pageContext.request.servletContext.contextPath}/EditarProfesionalServlet?id=${u.getId()}"><button class="btn btn-primary">Edit</button></a></f:if></td>
				</tr>
			</f:forEach>
		</tbody>
	</table>
</div>
</body>
</html>