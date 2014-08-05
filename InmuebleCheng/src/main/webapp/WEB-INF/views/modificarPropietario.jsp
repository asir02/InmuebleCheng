<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar detalle del propietario</title>
</head>
<body>
Datos del propietario<br />
<br />
<form:form method="post" commandName="propietario">
	<form:hidden path="idPropietario" />
	Nombre:
	<form:input path="nombre"/><br />
	<br />
	
	DNI:
	<form:input path="dni"/><br />
	<br />
	
	<input type="submit" value="Guardar" />
</form:form>

</body>
</html>