<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<title>Crear Usuario</title>
</head>
<body class="container">
<header>
	<jsp:include page="Menu.jsp"></jsp:include>
</header>
<form action="CrearUsuarioServlet" method="post" name="forma" onsubmit="return validateNombre()" class="form">
<div class="mb-3">
    <label for="nom" class="form-label">Nombre usuario:</label>
    <input type="text" class="form-control" id="nom" placeholder="Nombre" name="nombre">
</div>
<div class="mb-3">
<div class="form-check">
    <input type="radio" class="form-check-input" id="cliente" name="tipo" value="CLIENTE" checked>
  	<label for="cliente" class="form-check-label">Cliente</label>
</div>
<div class="form-check">
  	<input type="radio" class="form-check-input" id="admin" name="tipo" value="ADMINISTRATIVO">
  	<label for="admin" class="form-check-label">Administrativo</label>
</div>
<div class="form-check">
  	<input type="radio" class="form-check-input" id="profe" name="tipo" value="PROFESIONAL">
  	<label for="profe" class="form-check-label">Profesional</label>
</div>
</div>
<div class="rows">
	<button type="submit" class="btn btn-primary">Enviar</button>
</div>
</form>
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