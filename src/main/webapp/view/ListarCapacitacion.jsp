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
<title>Listar Capacitaciones</title>
</head>
<body class="container">
<header>
	<jsp:include page="Menu.jsp"></jsp:include>
</header>
<h1>Capacitaciones Registradas</h1>
<div class="table-responsive">
	<table class="table table-striped">
		<thead class="table-dark">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Detalle</th>
			</tr>
		</thead>
		<tbody>
			<f:forEach var="c" items="${capac}">
				<tr>
					<td><f:out value="${c.getId()}"></f:out></td>
					<td><f:out value="${c.getNombre()}"></f:out></td>
					<td><f:out value="${c.getDetalle()}"></f:out></td>
				</tr>
			</f:forEach>
		</tbody>
	</table>
</div>
</body>
</html>