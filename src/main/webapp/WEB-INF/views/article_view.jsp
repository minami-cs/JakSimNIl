<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="articleForm">
	<h2>글 내용 상세보기</h2>
	<section id="basicInfoArea">
		제 목 : ${article.title }
	</section>
	<section id="articleContentArea">${article.content }</section>
</section>