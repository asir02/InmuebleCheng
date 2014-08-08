<%@page import="org.apache.taglibs.standard.tag.el.core.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<c:set var="sum" value="${0}" />
		<c:forEach items="${inmuebles}" var="inmueble" varStatus="loopCount">
			<c:set var="sum" value="${sum+inmueble.precio}" />
    	</c:forEach>		
   
    	<td>Precio medio:</td><td><fmt:formatNumber type="number" maxFractionDigits="2" value="${sum/fn:length(inmuebles)}" />€</td>
    </tr>
    <tr>    
    	<c:set var="max" value="${0}" />
    	<c:forEach items="${inmuebles}" var="inmueble" varStatus="loopCount">
    		<c:set var="precio" value="${inmueble.precio}" />
    		<c:if test="${max<precio}">
    			<c:set var="max" value="${inmueble.precio}" />
    		</c:if>
    	</c:forEach>
    	
    	<td>Precio maximo:</td><td><fmt:formatNumber type="number" maxFractionDigits="2" value="${max}" />€</td>    	
    </tr>
    <tr>    
    	<c:set var="max" value="${0}" />
    	<c:forEach items="${inmuebles}" var="inmueble" varStatus="loopCount">
    		<c:set var="nid" value="${inmueble.propietario.idPropietario}" />
    		<c:set var="count" value="${0}"></c:set>
    		<c:forEach items="${inmuebles}" var="inmueble" varStatus="loopCount">
    			<c:if test="${nid==inmueble.propietario.idPropietario}">
    				<c:set var="count" value="${count+1}" />
    				<c:if test="${max<count}">
    					<c:set var="max" value="${count}" />
    					<c:set var="id" value="${inmueble.propietario.idPropietario}" />
    				</c:if>
    			</c:if>
    		</c:forEach>
    	</c:forEach>
    	
    	<td><a href="detallePropietario.html?id=${id}">Propietario con mas inmuebles:</a></td><td><c:out value="${max}" /></td>
    </tr>
    <tr>    
    	<c:set var="max" value="${0}" />
    	<c:forEach items="${inmuebles}" var="inmueble" varStatus="loopCount">
    		<c:set var="nid" value="${inmueble.inquilino.idInquilino}" />
    		<c:set var="count" value="${0}"></c:set>
    		<c:forEach items="${inmuebles}" var="inmueble" varStatus="loopCount">
    			<c:if test="${nid==inmueble.inquilino.idInquilino}">
    				<c:set var="count" value="${count+1}" />
    				<c:if test="${max<count}">
    					<c:set var="max" value="${count}" />
    					<c:set var="id" value="${inmueble.propietario.idPropietario}" />
    				</c:if>
    			</c:if>
    		</c:forEach>
    	</c:forEach>
    	
    	<td><a href="detallePropietario.html?id=${id}">Propietario con mas ganancias por inquilinos:</a></td><td><c:out value="${max}" /></td>
    </tr>
</table>

</body>
</html>