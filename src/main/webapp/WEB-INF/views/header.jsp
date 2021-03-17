<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/resources/css/header.css" />
<div id="h_wrap">
	<nav>
		<div id="logo">
			<a href="./"><img src="${path}/resources/img/logo.png" /></a>
		</div>
		<ul>
			<li><a href="./boardlist">작심하기</a></li>
			<c:choose>
				<c:when test="${sessionScope.id == null }">
					<li><a href="./login">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="./logout">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="./join">회원가입</a></li>
		</ul>
	</nav>
</div>