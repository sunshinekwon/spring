<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select car</title>
</head>
<body>
	<table>
		<tr><td>${selOneTitle}</td></tr>
	</table>
	
	<c:forEach var="i" begin="1" end="${imgCount}">
	<table>
		<tr><td>${selOneImg[imgCount]}</td></tr>
	</table>
	</c:forEach>
	
</body>
</html>