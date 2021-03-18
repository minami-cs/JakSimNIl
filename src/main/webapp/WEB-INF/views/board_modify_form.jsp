<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 게시판 등록 -->

<section id="writeForm">
	<h2>게시판글수정</h2>
	<form action="./boardupdate" method="post">
		<input type="hidden" name="writer" value="${writer }" />
		<table>
			<tr>
				<td class="td_left"><label for="title">제목</label></td>
				<td class="td_right"><input name="title" type="text" id="title"
					value="${title}" /></td>
			</tr>
			<tr>
				<td class="td_left"><label for="category">카테고리</label></td>
				<td class="td_right"><select name="category">

						<option value="study" id="category"
							<c:if test="${category == '공부' }">selected</c:if>>공부</option>
						<option value="work_out" id="category"
							<c:if test="${category == '운동' }">selected</c:if>>운동</option>
						<option value="hobby" id="category"
							<c:if test="${category == '취미' }">selected</c:if>>취미</option>

				</select></td>
			</tr>
			<tr>
				<td class="td_left"><label for="j_days">작심기간</label></td>
				<td class="td_right"><input type="radio" name="j_days"
					value="3" id="j_days"
					<c:if test="${j_days eq '3' }">checked</c:if>>3일 <input
					type="radio" name="j_days" value="5" id="j_days"
					<c:if test="${j_days eq '5' }">checked</c:if>>5일 <input
					type="radio" name="j_days" value="7" id="j_days"
					<c:if test="${j_days eq '7' }">checked</c:if>>7일 <input
					type="radio" name="j_days" value="14" id="j_days"
					<c:if test="${j_days eq '14' }">checked</c:if>>2주 <input
					type="radio" name="j_days" value="30" id="j_days"
					<c:if test="${j_days eq '30' }">checked</c:if>>1달</td>
			</tr>
			<tr>
				<td class="td_left"><label for="content">내용</label></td>
				<td><textarea id="content" name="content" cols="40" rows="15">${content}</textarea>
				</td>
			</tr>
			<tr>
				<td><button type="submit" value="등록">수정</button></td>
				<td><a href="javascript:history.go(-1)">뒤로</a></td>
			</tr>
		</table>
	</form>
</section>