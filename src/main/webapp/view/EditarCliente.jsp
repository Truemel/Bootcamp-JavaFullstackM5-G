<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<link href="view/styles.css" rel="stylesheet">
<title>Editar Cliente</title>
</head>
<body class="container">
<header>
	<jsp:include page="Menu.jsp"></jsp:include>
</header>
<form action="EditarClienteServlet" method="post" name="forma" onsubmit="return validateNombre()" class="form">
<div class="mb-3">
	<label class="form-label bordes">ID: ${cliente.getId()}</label>
</div>
<div class="mb-3">
	<label class="form-label bordes">Tipo: ${cliente.getTipo()}</label>
</div>
<div class="mb-3">
    <label for="nom" class="form-label">Nombre usuario:</label>
    <input type="text" class="form-control" id="nom" placeholder="Nombre" name="nombre" value="${cliente.getNombre()}">
</div>
<div class="rows">
	<button type="submit" class="btn btn-primary">Enviar</button>
</div>
<script>
	function validateNombre(){
		var nom = document.forms["forma"]["nombre"].value;
		if(nom.length < 10 || nom.length > 50){
			alert("Error, nombre mal ingresado, debe tener entre 10 y 50 caracteres");
			return false;
		}
	}
</script>
</body>
</html>