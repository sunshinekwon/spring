<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>carwow에 오신것을 환영합니다.</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.loginId != 'nothing'}">
			<table>
				<tr>
					<td>${sessionScope.loginId}님 환영합니다.</td>
					<td><a href="/cargood/logout">로그아웃</a></td>
				</tr>
			</table>
		</c:when>
		<c:when test="${sessionScope.loginId == 'nothing'}">
			<table>
				<tr>
					<td><a href="/cargood/login">로그인</a></td>
					<td><a href="/cargood/memberJoin">회원가입</a></td>
				</tr>
			</table>
		</c:when>
	</c:choose>
	
	<table>
		<tr>
			<td><a href="/cargood/selOneCarList?selTitle=${mainTitle1}">${mainTitle1}</a></td>
		</tr>
		<tr>
			<td>${mainImg1}</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/cargood/selOneCarList?selTitle=${mainTitle2}">${mainTitle2}</a></td>
		</tr>
		<tr>
			<td>${mainImg2}</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/cargood/selOneCarList?selTitle=${mainTitle3}">${mainTitle3}</a></td>
		</tr>
		<tr>
			<td>${mainImg3}</td>
		</tr>
	</table>
</body>
</html>