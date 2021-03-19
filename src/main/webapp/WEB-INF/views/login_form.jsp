<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/resources/css/signform.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path }/resources/js/login.js"></script>
<div id="formbox">
	<form action="./login" method="post" id="login">
		<h2>로그인</h2>
		<table>
			<tr>
				<td class="td_left">아이디</td>
				<td class="td_right"><input type="text" name="id" id="login_id" /></td>
			</tr>
			<tr>
				<td class="td_left">비밀번호</td>
				<td class="td_right"><input type="password" name="password"
					id="login_pass" /></td>
			</tr>
			<tr>
				<td class="td_left"></td>
				<td class="td_right"><button type="submit" value="로그인"
						id="loginbtn">로그인</button></td>
			</tr>
		</table>
	</form>
	<div id="gotojoin">
		<p>
			아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;&nbsp;<a href="./join">10초만에
				회원가입하기</a>
		</p>
	</div>
</div>
