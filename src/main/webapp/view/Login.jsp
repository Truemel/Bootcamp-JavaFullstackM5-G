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
<title>Login</title>
</head>
<body class="container">
<header><a class="mb-3" href="InicioServlet">Volver al Inicio</a></header>
<form action="submit" method="post" class="form">
	<div class="rows">
		<label class="form-label" for="run">Rut</label>
		<input id="run" name="rut" type="number" placeholder="123456789" class="form-control">
	</div>
	<div class="rows">
		<label class="form-label" for="pass">Password</label>
		<input id="pass" name="password" type="password" placeholder="Password" class="form-control">
	</div>
	<div class="rows">
		<button type="submit" class="btn btn-primary">Enviar</button>
	</div>
</form>
</body>
</html>