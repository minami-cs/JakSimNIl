<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/resources/css/boardwrite.css" />
<!-- 게시판 등록 -->
<form action="./boardwrite" method="post">
	<input type="hidden" name="id" value="${id }" />
	<h2>작심 글 등록</h2>
	<table>
		<tr>
			<td class="td_left"><label for="writer">작성자</label></td>
			<td class="td_right"><p id="writer">${id }</p></td>
		</tr>
		<tr>
			<td class="td_left"><label for="category">카테고리</label></td>
			<td class="td_right"><select name="category">
					<option value="study" id="category">공부</option>
					<option value="work_out" id="category">운동</option>
					<option value="hobby" id="category">취미</option>
			</select></td>
		</tr>
		<tr>
			<td class="td_left"><label for="j_days">작심기간</label></td>
			<td class="td_right"><input type="radio" name="j_days" value="3" id="j_days" checked>3일
			<input type="radio" name="j_days" value="5" id="j_days">5일
			<input type="radio" name="j_days" value="7" id="j_days">7일
			<input type="radio" name="j_days" value="14" id="j_days">2주
			<input type="radio" name="j_days" value="30" id="j_days">1달</td>
		</tr>
		<tr>
			<td class="td_left"><label for="title">제목</label></td>
			<td class="td_right"><input name="title" type="text" id="title"
				required="required" /></td>
		</tr>
		<tr>
			<td class="td_left"><label for="content">내용</label></td>
			<td class="td_right" colspan="2"><textarea id="content"
					name="content" cols="40" rows="15" required="required"></textarea></td>
		</tr>
		<tr>
			<td class="td_merge" colspan="2"></td>
			<td><button type="reset" value="다시쓰기">다시쓰기</button></td>
		</tr>
		<tr>
			<td class="td_merge" colspan="2"></td>
			<td><button type="submit" value="등록">작심하기</button></td>
		</tr>
	</table>
</form>
<!-- 게시판 등록 -->
