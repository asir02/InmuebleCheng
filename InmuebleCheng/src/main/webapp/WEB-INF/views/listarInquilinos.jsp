<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.11.1.min.js' />" ></script>
<title>Listado de inquilinos</title>
</head>
<body>

<h2>
Listado de inquilinos
</h2>

<div>
	<input type="text" id="txtBuscar" placeholder="Buscar nombre del inquilino" size="30" />
	<input type="button" id="btnBuscar" value="buscar" onclick="buscar()" />
</div>

<div>
<a href="altaInquilino.html">
<input type="button" id="btnBuscar" value="Alta Inquilino" />
</a>
</div>

<table id="tblDatos" />

<c:forEach items="${inquilinos}" var="inquilino">
	<tr>
		<td>${inquilino.nombre}</td>
			<td>
				<a href="detalleInquilino.html?id=${inquilino.idInquilino}"><input type="button" value="Detalle"></a>
				<a href="modificarInquilino.html/${inquilino.idInquilino}"><input type="button" value="Modificar"></a>
				<a href="#" id="lnkBorrar" onclick="borrar(${inquilino.idInquilino})"><input type="button" value="Borrar"></a>
			</td>
	</tr>
</c:forEach>
</table>

</body>

<script type="text/javascript">

function borrar(id){
	var datas={idInquilino:id};
	var datasTransfer=JSON.stringify(datas);
	$.ajax(
		"inquilino",{
			data:datasTransfer,
			method:"DELETE",
			contentType:"application/json",
			success:function(res){
				alert(res);
				$("txtBuscar").text("");
				buscar();
			},
			error:function(res){
				alert(JSON.stringify(res));
			}
		}
	);
}

function buscar(){
	var tx=$("#txtBuscar").val();
	if(tx==""){
		tx="????";
	}
	var url="inquilino/buscar/"+tx;
	
	$.get(url,function(res){
		var table=$("#tblDatos");
		
		$("#tblDatos tr").each(function(){
			$(this).remove();
		});
		
		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td><a href='detalleInquilino.html?id="+res[i].idInquilino+"'><input type='button' value='Detalle' /></a></td>";
			h+="<td><a href='modificarInquilino.html/"+res[i].idInquilino+"'><input type='button' value='Modificar' /></a></td>";
			h+="<td><a href='#' onclick='borrar("+res[i].idInquilino+")'><input type='button' value='Borrar' /></a></td>";
			h+="</tr>";
			table.append(h);
		}
	});
}

</script>
</html>