<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar del inquilino</title>
</head>
<body>
Datos del inquilino<br />
<br />
<form:form method="post" commandName="inquilino">
	<form:hidden path="idInquilino" />
	Nombre:
	<form:input path="nombre"/><br />
	<br />

	DNI:
	<form:input path="dni"/><br />
	<br />

	Edad:
	<form:input path="edad"/><br />
	<br />

	Trabaja:
	<form:input path="trabaja"/><br />
	<br />

	<input type="submit" value="Guardar" />

</form:form>

</body>
</html>
