<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
<title>Detalle de Inmueble</title>
</head>
<body>
<h1>Detalle de Inmueble</h1>
<table>
	<tr>
		<td>idInmueble:</td><td>${inmueble.idInmueble}</td>
	</tr>
	<tr>
		<td>Direccion:</td><td>${inmueble.direccion}</td>
	</tr>
	<tr>
		<td>Precio:</td><td>${inmueble.precio}</td>
	</tr>
	<tr>
		<td>Propietario:</td><td>${inmueble.propietario.nombre}</td>
		<td><a href="#" onclick="dp(${inmueble.propietario.idPropietario})">Detalle propietario</a></td>
	</tr>
	<tr>
		<td>Inquilino:</td><td>${inmueble.inquilino.nombre}</td>
		<td><a href="#" onclick="di(${inmueble.inquilino.idInquilino})">Detalle inquilino</a></td>
	</tr>
</table>

<table id="divDetail" />

<script type="text/javascript">

function dp(id){

	var url="propietario/"+id;
	
	$.get(url,function(res){

		var tbl="<tr><td colspan='2'><h3>Propietario</h3></td></tr>";
		tbl+="<tr><td>nombre:</td><td>"+res.nombre+"</td></tr>";
		tbl+="<tr><td>dni:</td><td>"+res.dni+"</td></tr>";
		tbl+="<tr><td>idPropietario:</td><td>"+res.idPropietario+"</td></tr>";
	
		$("#divDetail").html(tbl);

		}
	);
		
}

function di(id){

	var url="inquilino/"+id;
	
	$.get(url,function(res){

		var tbl="<tr><td colspan='2'><h3>Inquilino</h3></td></tr>";
		tbl+="<tr><td>nombre:</td><td>"+res.nombre+"</td></tr>";
		tbl+="<tr><td>dni:</td><td>"+res.dni+"</td></tr>";
		tbl+="<tr><td>idInquilinoo:</td><td>"+res.idInquilino+"</td></tr>";
		tbl+="<tr><td>edad:</td><td>"+res.edad+"</td></tr>";
		tbl+="<tr><td>trabaja:</td><td>"+res.trabaja+"</td></tr>";
	
		$("#divDetail").html(tbl);

		}
	);
		
}

</script>

</body>
</html>