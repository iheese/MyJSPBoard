<%@page import="com.study.biz.user.UserVO"%>
<%@ page contentType="text/html; charset=UTF-8"
	errorPage="errors/boardError.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 프로그램</title>
</head>
<body>
	<hr>
	<center>
		<a href="index.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<!-- 세션에 담긴 user 객체 유무에 따라 header부분이 변경된다. -->
		<%
		UserVO user =(UserVO) session.getAttribute("user");
		if(user==null) {
		%>
		<a href="insertUserView.do">회원가입</a>&nbsp;&nbsp;&nbsp; 
		<a href="loginView.do">로그인</a>&nbsp;&nbsp;&nbsp;
		<%
		} else {
		%>
		<a href="insertBoardView.do">글 등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="getBoardList.do">글 목록</a>&nbsp;&nbsp;&nbsp;
		<a href="logout.do">로그아웃</a>&nbsp;&nbsp;&nbsp;
		<%
		}
		%>
	</center>
	<hr>