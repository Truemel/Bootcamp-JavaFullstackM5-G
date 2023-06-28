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
<title>Crear Capacitación</title>
</head>
<body class="container">
<header>
	<jsp:include page="Menu.jsp"></jsp:include>
</header>
<form action="CrearCapacitacionServlet" method="post" name="forma" onsubmit="return validaciones()" class="form">
<div class="mb-3">
    <label for="nom" class="form-label">Nombre capacitación:</label>
    <input type="text" class="form-control" id="nom" placeholder="Nombre" name="nombre">
</div>
<div class="mb-3">
    <label for="det" class="form-label">Detalle:</label>
    <textarea rows="20" cols="100" class="form-control" id="det" placeholder="Detalle" name="detalle"></textarea>
</div>
<div class="rows">
  	<button type="submit" class="btn btn-primary">Enviar</button>
</div>
</form>
<script type="text/javascript">
	function validaciones(){
		if(!validateNombre() || !validateDetalle())
			return false;
	}

	function validateNombre(){
		var nom = document.forms["forma"]["nombre"].value;
		if(nom.length < 10 || nom.length > 50){
			alert("Error, nombre mal ingresado, debe tener entre 10 y 50 caracteres");
			return false;
		}
		return true;
	}
	
	function validateDetalle(){
		var det = document.forms["forma"]["detalle"].value;
		if(det == "" || det.length > 2000){
			alert("Error, detalle mal ingresado debe tener entre 1 y 2000 caracteres");
			return false;
		}
		return true;
	}
</script>
</body>
</html>