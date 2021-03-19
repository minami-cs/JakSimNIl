<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/resources/css/signform.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path }/resources/js/join.js"></script>
<div id="formbox">
	<form action="./join" method="post">
		<h2>간편회원가입</h2>
		<table>
			<tr>
				<td class="td_left"><label for="id">아이디</label></td>
				<td class="td_right"><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="password">비밀번호</label></td>
				<td class="td_right"><input type="password" name="password"
					id="password"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="name">이름</label></td>
				<td class="td_right"><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="email">이메일</label></td>
				<td class="td_right"><input type="text" name="email" id="email"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit" value="가입" id="joinbtn">가입</button></td>
			</tr>
		</table>
	</form>
</div>