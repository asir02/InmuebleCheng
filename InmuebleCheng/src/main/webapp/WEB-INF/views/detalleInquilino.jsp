<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
<title>Detalle de Inquilino</title>
</head>
<body>
<h1>Detalle de Inquilino</h1>
<table>
	<tr>
		<td>Nombre:</td><td>${inquilino.nombre}</td>
	</tr>
	<tr>
		<td>DNI:</td><td>${inquilino.dni}</td>
	</tr>
	<tr>
		<td>idInquilino:</td><td>${inquilino.idInquilino}</td>
	</tr>
	<tr>
		<td>Edad:</td><td>${inquilino.edad}</td>
	</tr>
	<tr>
		<td>Trabaja:</td><td>${inquilino.trabaja}</td>
	</tr>
</table>
</body>
</html>