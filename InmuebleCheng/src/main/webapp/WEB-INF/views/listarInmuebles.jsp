<%@page import="org.apache.taglibs.standard.tag.el.core.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
<title>Listado de Inmuebles</title>
</head>
<body>

<h2>
Listado de Inmuebles
</h2>

<div>
	<input type="text" id="txtBuscar" placeholder="Buscar por nombre de la via" size="30" />
	<input type="button" id="btnBuscar" value="buscar por nombre de la via" onclick="buscar()" />
</div>

<div>
	<input type="text" id="precioBuscar" placeholder="Buscar por precio" size="28" />€
	<input type="button" id="btnBuscar" value="buscar por precio menor o igual" onclick="buscarPrecioMenor()" />
	<input type="button" id="btnBuscar" value="buscar por precio mayor o igual" onclick="buscarPrecioMayor()" />
</div>

<div>
	<a href="altaInmueble.html">
		<input type="button" id="btnBuscar" value="Alta Inmueble" />
	</a>
</div>

<br />

<div>
	<a href="estadisticasInmuebles.html">Estadisticas de los inmuebles</a>
</div>

<br />

<table id="tblDatas">

<c:forEach items="${inmuebles}" var="inmueble">
	<tr>
		<td>${inmueble.direccion}</td>
		<td>
			<a href="detalleInmueble.html?id=${inmueble.idInmueble}"><input type="button" value="Detalle" /></a>
			<a href="modificarInmueble.html/${inmueble.idInmueble}"><input type="button" value="Modificar" /></a>		
			<a href="#" id="lnkBorrar" onclick="borrar(${inmueble.idInmueble})"><input type="button" value="Borrar" /></a>
		</td>
	</tr>
</c:forEach>

</table>

</body>

<script type="text/javascript">

function borrar(id){

	var datas={idInmueble:id};

	var datasToString=JSON.stringify(datas);

	$.ajax(
			"inmueble",{
				data:datasToString,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("inmueble borrado");
					$("#txtBuscar").text("");
					buscar();

					},
				error: function(res){
					alert(JSON.stringify(res));
					}
				}
			);
	
}

function buscar(){
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="";
	var url="inmueble/buscar/"+tx;	

	$.get(url,function(res){

		var table=$("#tblDatas");

		$("#tblDatas tr").each(function(){
				$(this).remove();
		});

		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td><a href='detalleInmueble.html?id="+res[i].idInmueble+"'><input type='button' value='Detalle' /></td>";
			h+="<td><a href='modificarInmueble.html/"+res[i].idInmueble+"'><input type='button' value='Modificar' /></a></td>";
			h+="<td><a href='#' onclick='borrar("+res[i].idInmueble+")'><input type='button' value='Borrar' /></a></td>";
			h+="</tr>";	
			table.append(h);
		}

	});
	
}

function buscarPrecioMenor(){
	var tx=$("#precioBuscar").val();
	var url="inmueble/buscarPrecioMenor/"+tx;	

	$.get(url,function(res){

		var table=$("#tblDatas");

		$("#tblDatas tr").each(function(){
				$(this).remove();
		});

		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td><a href='detalleInmueble.html?id="+res[i].idInmueble+"'><input type='button' value='Detalle' /></td>";
			h+="<td><a href='modificarInmueble.html/"+res[i].idInmueble+"'><input type='button' value='Modificar' /></a></td>";
			h+="<td><a href='#' onclick='borrar("+res[i].idInmueble+")'><input type='button' value='Borrar' /></a></td>";
			h+="</tr>";	
			table.append(h);
		}

	});
	
}

function buscarPrecioMayor(){
	var tx=$("#precioBuscar").val();
	var url="inmueble/buscarPrecioMayor/"+tx;	

	$.get(url,function(res){

		var table=$("#tblDatas");

		$("#tblDatas tr").each(function(){
				$(this).remove();
		});

		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td><a href='detalleInmueble.html?id="+res[i].idInmueble+"'><input type='button' value='Detalle' /></td>";
			h+="<td><a href='modificarInmueble.html/"+res[i].idInmueble+"'><input type='button' value='Modificar' /></a></td>";
			h+="<td><a href='#' onclick='borrar("+res[i].idInmueble+")'><input type='button' value='Borrar' /></a></td>";
			h+="</tr>";	
			table.append(h);
		}

	});
	
}

</script>

</html>

