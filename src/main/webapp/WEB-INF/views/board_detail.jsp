<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${path}/jsni/resources/css/boarddetail.css" />
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
<div id="btn_box">
	<a href="./boardlist?curPage=${curPage}"><button>목록</button></a> <a
		href="./boardmodify?board_no=${article.board_no }&curPage=${curPage }"><button>수정하기</button></a>
	<a href="./boarddelete?board_no=${article.board_no }"><button>삭제하기</button></a>
</div>