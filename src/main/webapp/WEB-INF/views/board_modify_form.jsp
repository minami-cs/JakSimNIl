<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${path}/jsni/resources/css/boardmodify.css" />
<!-- 게시판 등록 -->
<form action="./boardmodify" method="post">
	<input type="hidden" name="board_no" value="${board_no }" /> <input
		type="hidden" name="curPage" value="${curPage }" /> <input
		type="hidden" name="writer" value="${writer }" />
	<h2>작심 수정</h2>
	<table>
		<tr>
			<td class="td_left"><label for="title">제목</label></td>
			<td class="td_right"><input name="title" type="text" id="title" /></td>
		</tr>
		<tr>
			<td class="td_left"><label for="category">카테고리</label></td>
			<td class="td_right"><select name="category">

					<option value="공부" id="category"
						<c:if test="${category == '공부' }">selected</c:if>>공부</option>
					<option value="운동" id="category"
						<c:if test="${category == '운동' }">selected</c:if>>운동</option>
					<option value="취미" id="category"
						<c:if test="${category == '취미' }">selected</c:if>>취미</option>

			</select></td>
		</tr>
		<tr>
			<td class="td_left"><label for="j_days">작심기간</label></td>
			<td class="td_right"><input type="radio" name="j_days" value="3"
				id="j_days" <c:if test="${j_days == 3 }">checked</c:if>>3일 <input
				type="radio" name="j_days" value="5" id="j_days"
				<c:if test="${j_days == 5 }">checked</c:if>>5일 <input
				type="radio" name="j_days" value="7" id="j_days"
				<c:if test="${j_days == 7 }">checked</c:if>>7일 <input
				type="radio" name="j_days" value="14" id="j_days"
				<c:if test="${j_days == 14 }">checked</c:if>>2주 <input
				type="radio" name="j_days" value="30" id="j_days"
				<c:if test="${j_days == 30 }">checked</c:if>>1달</td>
		</tr>
		<tr>
			<td class="td_left"><label for="content">내용</label></td>
			<td><textarea id="content" name="content" cols="40" rows="15">${content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit" value="등록" id="m_btn">수정</button></td>
		</tr>
	</table>
</form>