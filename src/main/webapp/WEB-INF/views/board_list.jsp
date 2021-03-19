<%@ page import="java.util.ArrayList"%>
<%@ page import="com.jaksim.jsni.bean.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/resources/css/boardlist.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<c:if test="${userId == null}">
	<script>
	$(function() {
		$('#write').on('click', function() {
			alert("로그인 후에 글쓰기가 가능합니다.");
			location.href="./login";
			return false;
		});
	});
	</script>
</c:if>
<h2>함께하는 작심N일</h2>
<div id="searchbox">
	<form action="./boardlist" method="post" name="searchArticleForm">
		<select name="searchOption">
			<option value="all"><c:out
					value="${map.searchOption == 'all' ? '' : ''}" />제목+내용
			</option>
			<option value="title"><c:out
					value="${map.searchOption == 'title' ? '' : ''}" />제목
			</option>
			<option value="content"><c:out
					value="${map.searchOption == 'content' ? '' : ''}" />내용
			</option>
			<option value="writer"><c:out
					value="${map.searchOption == 'writer' ? '' : ''}" />작성자
			</option>
		</select> <input type="text" name="keyword" value="${map.keyword }" />
		<button type="submit" value="검색" id="search">검색</button>
	</form>
</div>
<c:choose>
	<c:when test="${not empty map.keyword }">
		<div id="resultbox">
			<p>
				<strong>'${map.keyword}' </strong>검색 결과: <strong>${map.count }</strong>개의
				게시글이 있습니다.
			</p>
		</div>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
<table id="list_table">
	<thead>
		<tr>
			<td class="number" id="thead">#</td>
			<td class="duration" id="thead">작심기간</td>
			<td class="title" id="thead">제목</td>
			<td class="writer" id="thead">작성자</td>
			<td class="date" id="thead">작성일</td>
			<td class="hit" id="thead">조회</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="article" items="${map.articles }">
			<tr>
				<td class="number">${article.board_no }</td>
				<td class="duration">${article.j_days }일</td>
				<td><a
					href="./boarddetail?board_no=${article.board_no}&curPage=${map.boardPageMaker.curPage}">
						${article.title} </a></td>
				<td class="writer">${article.writer }</td>
				<td class="date"><fmt:formatDate value="${article.w_date }"
						pattern="yy.MM.dd" /></td>
				<td class="hit">${article.v_count }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center"><c:if
					test="${map.boardPageMaker.curView > 1}">
					<a href="./boardlist?curPage=1">[처음]</a>
				</c:if> <c:if test="${map.boardPageMaker.curView > 1}">
					<a href="./boardlist?curPage=${map.boardPageMaker.prev}">[이전]</a>

				</c:if> <c:forEach var="num" begin="${map.boardPageMaker.viewStart}"
					end="${map.boardPageMaker.viewEnd}">
					<c:choose>
						<c:when test="${num == map.boardPageMaker.curPage}">
							<span style="color: #07BCF4; font-weight: 700;">${num}</span>&nbsp;
</c:when>
						<c:otherwise>
							<a href="./boardlist?curPage=${num}">${num}</a>&nbsp;
</c:otherwise>
					</c:choose>
				</c:forEach> <c:if
					test="${map.boardPageMaker.curView <= map.boardPageMaker.totalView}">
					<a href="./boardlist?curPage=${map.boardPageMaker.next}">[다음]</a>
				</c:if> <c:if
					test="${map.boardPageMaker.curPage <= map.boardPageMaker.totalPage}">
					<a href="./boardlist?curPage=${map.boardPageMaker.totalPage}">[끝]</a>
				</c:if></td>
		</tr>
		<tr>
			<td colspan="6" align="right"><a href="./boardwrite"><button
						id="write">글쓰기</button></a></td>
		</tr>
	</tbody>
</table>
