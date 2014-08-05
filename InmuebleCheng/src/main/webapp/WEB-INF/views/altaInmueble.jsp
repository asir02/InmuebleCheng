<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta del inmueble</title>
</head>
<body>
Datos del inmueble<br />
<br />
<form:form method="post" commandName="inmueble">

Direccion:
<form:input path="direccion"/><br />
<br />

Precio:
<form:input path="precio"/><br />
<br />

Propietario:
<form:select path="idPropietario">
	<form:options items="${propietarios}"/>
</form:select><br />
<br />

Inquilino:
<form:select path="idInquilino">
	<form:options items="${inquilinos}"/>
</form:select><br />
<br />

<input type="submit" value="Guardar" />

</form:form>

</body>
</html>