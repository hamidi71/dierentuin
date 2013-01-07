<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Honden</title>
</head>
<body>
<h1>Honden</h1>
 
<c:if test="${not empty honden}" >
<ul>
	<c:forEach items="${honden}" var="hond">		
			<li><c:out value="${hond.naam}" /></li>	
	</c:forEach>	
</ul>
</c:if>
<c:if test="${empty honden}" >
	Geen honden aanwezig. 
</c:if>
 
<a href="/DierenTuin/control/hond/addhond.html">Nieuwe Hond</a><br/>
<a href="/DierenTuin/index.html">Home</a>
</body>
</html>