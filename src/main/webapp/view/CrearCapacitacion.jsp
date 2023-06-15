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
<form action="submit">
<div class="mb-3">
    <label for="nom" class="form-label">Nombre capacitación:</label>
    <input type="text" class="form-control" id="nom" placeholder="Nombre" name="nombre">
</div>
<div class="mb-3">
    <label for="cap" class="form-label">Duración:</label>
    <input type="text" class="form-control" id="cap" placeholder="Duración" name="duracion">
</div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
</body>
</html>