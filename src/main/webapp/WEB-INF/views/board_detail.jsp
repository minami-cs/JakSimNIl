<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${path}/jsni/resources/css/boarddetail.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path }/jsni/resources/js/boarddetail.js"></script>
<div id="a_wrap">
	<input type="hidden" name="board_no" value="${board_no }" />
	<h2>작심한 내용보기</h2>
	<table id="a_table">
		<thead>
			<tr>
				<td>[작심${article.j_days}일/${article.category}] ${article.title }</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${article.content }</td>
			</tr>
		</tbody>
	</table>
</div>
<div id="r_wrap">
	<table id="r_table">
		<tr>
			<td><textarea rows="8" cols="110"></textarea></td>
		</tr>
		<tr>
			<td><button>댓글 등록</button></td>
		</tr>
	</table>
</div>
<div id="btn_box">
	<a href="./boardlist?curPage=${curPage}"><button>목록</button></a>
	<c:if test="${userId == article.writer}">
		<a
			href="./boardmodify?board_no=${article.board_no }&curPage=${curPage }"><button>수정하기</button></a>
		<a href="./boarddelete?board_no=${article.board_no }"><button
				id="deletebtn">삭제하기</button></a>
	</c:if>
</div>