<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
<title>Listado de Propietarios</title>
</head>
<body>

<h2>
Listado de Propietarios
</h2>

<div>
	<input type="text" id="txtBuscar" placeholder="Buscar nombre del propietario" size="30" />
	<input type="button" id="btnBuscar" value="buscar" onclick="buscar()" />
</div>

<div>
<a href="altaPropietario.html">
<input type="button" id="btnBuscar" value="Alta Propietario" />
</a>
</div>


<table id="tblDatas">

<c:forEach items="${propietarios}" var="propietario">
	<tr>
		<td>${propietario.nombre}</td>
		<td>
			<a href="detallePropietario.html?id=${propietario.idPropietario}"><input type="button" value="Detalle" /></a>
		</td>
		<td>
			<a href="modificarPropietario.html/${propietario.idPropietario}"><input type="button" value="Modificar" /></a>
		</td>		
		<td>
			<a href="#" id="lnkBorrar" onclick="borrar(${propietario.idPropietario})"><input type="button" value="Borrar" /></a>
		</td>
	</tr>
</c:forEach>

</table>

</body>

<script type="text/javascript">

function borrar(id){

	var datas={idPropietario:id};

	var datasToString=JSON.stringify(datas);

	$.ajax("propietario",{
		data:datasToString,
		method: "DELETE",
		contentType: "application/json",
		success: function(res){
			alert("propietario borrado");
			$("#txtBuscar").text("");
			buscar();

		},
		error: function(res){
			alert(JSON.stringify(res));
		}
	});	
}

function buscar(){
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="????";
	var url="propietario/buscar/"+tx;	

	$.get(url,function(res){

		var table=$("#tblDatas");

		$("#tblDatas tr").each(function(){
				$(this).remove();
		});

		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td><a href='detallePropietario.html?id="+res[i].idPropietario+"'><input type='button' value='Detalle' /></a></td>";
			h+="<td><a href='modificarPropietario.html/"+res[i].idPropietario+"'><input type='button' value='Modificar' /></a></td>";
			h+="<td><a href='#' onclick='borrar("+res[i].idPropietario+")'><input type='button' value='Borrar' /></a></td>";
			h+="</tr>";	
			table.append(h);
		}
	});
	
}

</script>

</html>