<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all car list</title>
</head>
<body>
<div id="top">
	자동차 전체게시판
</div>
<div id="middle">
	<c:if test="${carTitle1}!=null">
	<table>
		<tr>
			<td><a href="/cargood/selOneCarList?selTitle=${carTitle1}">${carTitle1}</a></td>
		</tr>
		<tr>
			<td>${carImg1}</td>
		</tr>
	</table>
	</c:if>
	<c:if test="${carTitle2}!=null">
	<table>
		<tr>
			<td><a href="/cargood/selOneCarList?selTitle=${carTitle2}">${carTitle2}</a></td>
		</tr>
		<tr>
			<td>${carImg2}</td>
		</tr>
	</table>
	</c:if><c:if test="${carTitle3}!=null">
	<table>
		<tr>
			<td><a href="/cargood/selOneCarList?selTitle=${carTitle3}">${carTitle3}</a></td>
		</tr>
		<tr>
			<td>${carImg3}</td>
		</tr>
	</table>
	</c:if>
</div>
<div class="paging"> <div class="element"> <c:set var="page" value="${selNum}"/> <!-- page maxpage를 넘었을 경우 제한 --> <c:if test="${page > pagingCount}"> <c:set var="page" value="${pagingCount}"/> </c:if> <!-- 페이지를 8개씩 나누기 위해 현재 페이지에 보여줄 max값 설정 --> <fmt:formatNumber value="${page/8 - (page/8 % 1)}" type="pattern" pattern="0" var="full"/> <c:set var="full" value="${full * 8}"/> <!-- prev(전페이지), next(다음페이지) 개수 설정 --> <c:set var="scope" value="${page%8}"/> <c:choose> <c:when test="${scope == 0}"> <c:set var="prev" value="8"/> <c:set var="next" value="1"/> </c:when> <c:when test="${scope < 9}"> <c:set var="prev" value="${scope}"/> <c:set var="next" value="${9-scope}"/> </c:when> </c:choose> <!-- prev 버튼 --> <c:if test="${page > 8}"> <fmt:formatNumber value="${(page-1)/8 - (((page-1)/8) % 1)}" type="pattern" pattern="0" var="prevb"/> <c:set value="${(prevb-1)*8 + 1}" var="prevb"/> <span id="prevBtn" class="prev button" value="${prevb}"></span> </c:if> <!-- 전 페이지 --> <c:if test="${page != 1}"> <c:set var="j" value="${prev}"/> <c:forEach var="i" begin="1" end="${prev-1}"> <c:set var="j" value="${j - 1}"/> <c:if test="${(page - j) > 0}"> <span class="no">${page - j}</span> </c:if> </c:forEach> </c:if> <!-- 현재 페이지 --> <span class="no selected">${page}</span> <!-- 다음 페이지 --> <c:if test="${page != pagingCount}"> <c:forEach var="i" begin="1" end="${next-1}"> <c:if test="${pagingCount >= page+i}"> <span class="no">${page+i}</span> </c:if> </c:forEach> </c:if> <!-- next 버튼 --> <c:if test="${pagingCount >= page + next}"> <fmt:formatNumber value="${(page-1)/8 - (((page-1)/8) % 1)}" type="pattern" pattern="0" var="nextb"/> <c:set value="${(nextb+1)*8 + 1}" var="nextb"/> <span id="nextBtn" class="next button" value="${nextb}"></span> </c:if> </div> </div>
</body>
</html>