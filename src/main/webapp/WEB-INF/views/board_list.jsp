<%@ page import="java.util.ArrayList"%>
<%@ page import="com.jaksim.jsni.bean.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/resources/css/boardlist.css" />
<h2>함께하는 작심N일</h2>
<table id="list_table">
	<thead>
		<tr>
			<td class="number" id="thead">#</td>
			<td class="duration" id="thead">작심기간</td>
			<td class="title" id="thead">제목</td>
			<td class="writer" id="thead">작성자</td>
			<td class="date" id="thead">작성일</td>
		</tr>
	</thead>
	<c:forEach var="article" items="${articles }">
		<tr>
			<td class="number">${article.board_no }</td>
			<td class="duration">${article.j_days }일</td>
			<td><a href="./articledetail?board_no=${article.board_no}&page=${criteria.page}">
					${article.title} </a></td>
			<td class="writer">${article.writer }</td>
			<td class="date"><fmt:formatDate value="${article.w_date }" pattern="yy.MM.dd" /></td>
		</tr>
	</c:forEach>
</table>
<div id="btn">
	<a href="./boardwrite"><button id="write">글쓰기</button></a>
</div>