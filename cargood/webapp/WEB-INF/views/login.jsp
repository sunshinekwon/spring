<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form action="/cargood/loginCon" method="POST">
		<table>
			<tr>
				<td>아이디:<input type="text" name="sendId"></td>
			</tr>
			<tr>
				<td>비밀번호:<input type="password" name="sendPw"></td>
			</tr>
			<tr><input type="submit">입장하기</tr>
		</table>
	</form>
</body>
</html>